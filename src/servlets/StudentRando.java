package servlets;

import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.util.Random;

@WebServlet("/studentresults")
public class StudentRando extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        String url = "/studentresults.jsp";
        String time = request.getParameter("startTime");
        int startTime = extractor(time);
        int numberOfStudents = Integer.valueOf(request.getParameter("numberOfStudents"));
        char students [] = studentCreator(numberOfStudents);

        String[] timeSlots = timeSlots(startTime, numberOfStudents);
        students = randomStudent(students);

        request.setAttribute("numberOfStudents", numberOfStudents);
        request.setAttribute("startTime", startTime);
        request.setAttribute("students", students);
        request.setAttribute("timeSlots", timeSlots);
        getServletContext().getRequestDispatcher(url).forward(request, response);

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        doPost(request, response);
    }

    protected int extractor(String time) {

        int semiColon = time.indexOf(":");

        int hour = Integer.parseInt(time.substring(0, semiColon));
        int min = Integer.parseInt(time.substring(semiColon+1));

        return (hour * 60) + min;

    }

    protected String [] timeSlots(int startTime, int numOfSlots) {

        String [] time = new String [numOfSlots];
        time[0] = timeToString(startTime);



        for(int i = 1; i < numOfSlots; i++) {

            startTime += 10;
            time[i] = timeToString(startTime);

        }
        return time;

    }

    protected String timeToString(int time) {

        String hour = Integer.toString(time/60);
        String mins = Integer.toString(time - ((time/60) * 60));

        if(mins.length() < 2)
            mins += "0";

        return hour + ":" + mins;

    }

    protected char [] studentCreator(int slots) {
        char [] students = new char [slots];

        char first = 'A';

        for(int i = 0; i < slots; i++) {
            students[i] = first++;
        }

        return students;
    }

    protected char[] randomStudent(char [] students) {

        Random rndm = new Random();
        for(int i = 0; i < students.length; i++) {
            int randomStu = rndm.nextInt(students.length-1);
            char temp = students[i];
            students[i] = students[randomStu];
            students[randomStu] = temp;
        }
        return students;

    }
}
