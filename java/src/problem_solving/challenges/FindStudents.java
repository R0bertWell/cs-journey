package problem_solving.challenges;

public class FindStudents {
    public static void findStudent(String[] allStudents, String studentName){
        for(String student : allStudents){
            if(student.equals(studentName)){
                System.out.println("Estudante encontrado : " + student);
                return;
            }
        }

        System.out.println("Estudante de nome " + studentName + " não encontrado!");
    }

    public static void main(String[] args) {
        Object[] arrayMix = {1, "a", 2.1, 12143L};

        for (Object mix : arrayMix){
            System.out.println(mix);
        }
        System.out.println(arrayMix);

        String[] students = {"Joao", "Maria", "Pedro", "Siqueira", "Amapa"};

        findStudent(students, "Pedro");
        findStudent(students, "Carago");

    }
}
