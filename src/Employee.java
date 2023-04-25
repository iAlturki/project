// Define a class for the employee
class Employee {
        private String firstName;
        private String lastName;
        private String role;
        private double salary;
    
        public Employee(String firstName, String lastName, String role, double salary) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.role = role;
            this.salary = salary;
        }
    
        public String getFullName() {
            return firstName + " " + lastName;
        }
    
        public String getRole() {
            return role;
        }
        
        public double getSalary() {
            return salary;
        }
    }
        