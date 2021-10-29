



public class Statistics {
    public static void main(String[] args) {
        Measurable[] workers = new Measurable[3];

        Employee firstWorker = new Employee("John Smith", 10000);
        workers[0] = firstWorker;
        Employee secondWorker = new Employee("John Smith 2", 7522);
        workers[1] = secondWorker;
        Employee thirdWorker = new Employee("John Smith 3", 45645);
        workers[2] = thirdWorker;

        System.out.println(average(workers));
        System.out.println(largest(workers));

    }

    static double average(Measurable[] objects) {
        double result = 0;

        for (Measurable object : objects) {
            result += object.getMeasure();
        }
         
        return result;
    }

    static String largest(Measurable[] objects){
        Employee result = (Employee) objects[0];

        for (Measurable obj : objects) {
            if (obj.getMeasure() > result.getMeasure()) {
                result = (Employee) obj;
            }
        }
        return result.getName();
        }


    
}
