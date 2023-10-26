public class MVC {
    public static class StudentModel {
        private String name;
        private int rollNumber;

        public StudentModel(String name, int rollNumber) {
            this.name = name;
            this.rollNumber = rollNumber;
        }

        public String getName() {
            return name;
        }

        public int getRollNumber() {
            return rollNumber;
        }

        public void setName(String name) {
            this.name = name;
        }

        public void setRollNumber(int rollNumber) {
            this.rollNumber = rollNumber;
        }
    }

    public static class StudentView {
        public void printStudentDetails(String studentName, int studentRollNumber) {
            System.out.println("Student: ");
            System.out.println("Name: " + studentName);
            System.out.println("Roll Number: " + studentRollNumber);
        }
    }

    public static class StudentController {
        StudentModel model;
        StudentView view;

        public StudentController(StudentModel model, StudentView view) {
            this.model = model;
            this.view = view;
        }

        public void updateView() {
            view.printStudentDetails(model.getName(), model.getRollNumber());
        }
    }

    public static void main(String[] args) {
        StudentModel model = new StudentModel("Tom", 20);
        StudentView view = new StudentView();
        StudentController controller = new StudentController(model, view);
        controller.updateView();
    }
}
