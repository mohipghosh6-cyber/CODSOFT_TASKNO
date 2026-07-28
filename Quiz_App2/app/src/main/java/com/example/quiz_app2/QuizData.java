package com.example.quiz_app2;

public class QuizData {

    public static String[] questions = {
            "What is the capital of India?",
            "Which planet is known as the Red Planet?",
            "Who invented Java?",
            "Which is the largest ocean?",
            "How many days are there in a leap year?",
            "Which language is used for Android development?",
            "What is 10 + 15?",
            "Who is known as the Father of the Nation?",
            "Which is the national animal of India?",
            "What is the currency of India?"
    };

    public static String[][] options = {
            {"Delhi", "Kolkata", "Mumbai", "Chennai"},
            {"Earth", "Mars", "Venus", "Jupiter"},
            {"James Gosling", "Dennis Ritchie", "Bill Gates", "Elon Musk"},
            {"Atlantic", "Indian", "Pacific", "Arctic"},
            {"365", "366", "364", "367"},
            {"Java", "Python", "C", "Swift"},
            {"20", "25", "30", "35"},
            {"Mahatma Gandhi", "Nehru", "Subhas Bose", "Bhagat Singh"},
            {"Tiger", "Lion", "Elephant", "Peacock"},
            {"Dollar", "Rupee", "Yen", "Euro"}
    };

    public static int[] answers = {
            0,
            1,
            0,
            2,
            1,
            0,
            1,
            0,
            0,
            1
    };
}
