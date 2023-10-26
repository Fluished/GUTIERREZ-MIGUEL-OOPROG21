import java.util.*;

class Student {
   Student(String studentId,String age,String yearLevel,String firstName,String middleName,String lastName,String suffix,String phoneNo,String email) {
      this.studentId = studentId;
      this.age = age;
      this.yearLevel = yearLevel;
      this.firstName = firstName;
      this.middleName = middleName;
      this.lastName = lastName;
      this.suffix = suffix;
      this.phoneNo = phoneNo;
      this.email = email;
   }
   String studentId,age,yearLevel,firstName, middleName, lastName, suffix, phoneNo, email;
   
   String setStudentId(String newStudentId) {
      return this.studentId = newStudentId;
   }
   
   String getStudentId() {
      return studentId;
   }
   
   String setAge(String newAge) {
      return this.age = newAge;
   }
   
   String getAge() {
      return age;
   }
   
   String setYearLevel(String newYearLevel) {
      return this.yearLevel = newYearLevel;
   }
   
   String getYearLevel() {
      return age;
   }
   
   String setFirstName(String newFirstName) {
      return this.firstName = newFirstName;
   }
   
   String getFirstName() {
      return firstName;
   }
   
   String setMiddleName(String newMiddleName) {
      return this.middleName = newMiddleName;
   }
   
   String getMiddleName() {
      return middleName;
   }
   
   String setLastName(String newLastName) {
      return this.lastName = newLastName;
   }
   
   String getLastName() {
      return lastName;
   }
   
   String setSuffix(String newSufffix) {
      return this.suffix = newSufffix;
   }
   
   String getSuffix() {
      return suffix;
   }
   
   String setPhoneNo(String newPhoneNo) {
      return this.phoneNo = newPhoneNo;
   }
   
   String getPhoneNo() {
      return suffix;
   }
   
   String setEmail(String newEmail) {
      return this.email = newEmail;
   }
   
   String getEmail() {
      return email;
   }
}

class Course {
   Course(String courseName,String courseCode,String department) {
      this.courseName = courseName;
      this.courseCode = courseCode;
      this.department = department;
   }
   
   String courseName, courseCode, department;
   
   String setCourseName(String newCourseName) {
      return this.courseName = newCourseName;
   }
   
   String getCourseName() {
      return courseName;
   }
   
   String setCourseCode(String newCourseCode) {
      return this.courseCode = newCourseCode;
   }
   
   String getCourseCode() {
      return courseCode;
   }
   
   String setDepartment(String newDepartment) {
      return this.department = newDepartment;
   }
   
   String getDepartment() {
      return department;
   }
}

class StudentApp {
   public static void main(String[] args) {
      Scanner scan = new Scanner(System.in);
      byte option, firstOption;
      String studentId,age,yearLevel,firstName, middleName, lastName, suffix, phoneNo, email;
      String courseCode, department;
      String courseName;
      
      System.out.println("\n===== STUDENT APP =====");
      
      do {
         System.out.println("\n[ 1. Create Student Record ]");
         System.out.println("[ 2. Exit ]");
         System.out.print(" == ");
         firstOption = scan.nextByte();
         switch(firstOption) {
            case 1:
               System.out.println("[ ENTER STUDENT DETAILS: ]");
               System.out.print("\n[] Student ID: ");
               studentId = scan.next();
               System.out.print("[] Age: ");
               age = scan.next();
               System.out.print("[] Year Level: ");
               yearLevel = scan.next();
               System.out.print("[] First Name: ");
               firstName = scan.next();
               System.out.print("[] Middle Name: ");
               middleName = scan.next();
               System.out.print("[] Last Name: ");
               lastName = scan.next();
               System.out.print("[] Suffix: ");
               suffix = scan.next();
               System.out.print("[] Phone No.: ");
               phoneNo = scan.next();
               System.out.print("[] Email: ");
               email = scan.next();
               
               Student student = new Student(studentId,age,yearLevel,firstName, middleName, lastName, suffix, phoneNo, email);
                                         
               System.out.println("[ 1. Bachelor of Science in Information Technology (BSIT) ]");
               System.out.println("[ 2. Bachelor of Science in Computer Science (BSCS) ]");
               System.out.println("[ 3. Associate of Computer Technology (ACT) ]");
               System.out.println("[ 4. Bachelor of Science in Mechanical Engineering (BSME) ]");
               System.out.println("[ 5. Bachelor of Science in Civil Engineering (BSCE) ]");
               System.out.print("[] Student Course: ");             
               courseName = scan.next();
               System.out.print("\n[] Student Course Code: ");
               courseCode = scan.next();
               System.out.print("[] Student Department: ");
               department = scan.next();
               
               Course studentCourse = new Course(courseName, courseCode, department);
               
               do {
                  System.out.println("\n[ 1. Update Student Details ]");
                  System.out.println("[ 2. Update Student Course Details ]");
                  System.out.println("[ 3. Display Student Record ]");
                  System.out.println("[ 4. Exit ]");
                  System.out.print(" == ");
                  option = scan.nextByte();
                  
                  switch(option) {
                     case 1:
                        System.out.println("[ ENTER STUDENT DETAILS: ]");
                        System.out.println("[] Student ID: ");
                        studentId = scan.nextLine();
                        student.setStudentId(studentId);
                        System.out.println("[] Age: ");
                        age = scan.nextLine();
                        student.setAge(age);
                        
                        System.out.println("[] Year Level: ");
                        yearLevel = scan.nextLine();
                        student.setYearLevel(yearLevel);
                        
                        System.out.println("[] First Name: ");
                        firstName = scan.nextLine();
                        student.setFirstName(firstName);
                    
                        System.out.println("[] Middle Name: ");
                        middleName = scan.nextLine();
                        student.setMiddleName(middleName);
                        
                        System.out.println("[] Last Name: ");
                        lastName = scan.nextLine();
                        student.setLastName(lastName);
                        
                        System.out.println("[] Suffix: ");
                        suffix = scan.nextLine();
                        student.setSuffix(suffix);
                        
                        System.out.println("[] Phone No.: ");
                        phoneNo = scan.nextLine();
                        student.setPhoneNo(phoneNo);
                        
                        System.out.println("[] Email: ");
                        email = scan.nextLine();
                        student.setEmail(email);
                        break;
                     case 2:
                        System.out.print("[] Student Course: ");
                        courseName = scan.nextLine();
                        studentCourse.setCourseName(courseName);
                        
                        System.out.print("[] Student Course Code: ");
                        courseCode = scan.next();
                        studentCourse.setCourseCode(courseCode);
                        
                        System.out.print("[] Student Department: ");
                        department = scan.nextLine();
                        studentCourse.setDepartment(department);
                        break;
                     case 3:
                        System.out.printf("\nStudent ID: %s",student.getStudentId());
                        System.out.printf("\nAge: %s",student.getAge());
                        System.out.printf("\nYear Level: %s",student.getYearLevel());
                        System.out.printf("\nFirst Name: %s",student.getFirstName());
                        System.out.printf("\nMiddle Name: %s",student.getMiddleName());
                        System.out.printf("\nLast Name: %s",student.getLastName());
                        System.out.printf("\nSuffix: %s",student.getSuffix());
                        System.out.printf("\nPhone No.: %s",student.getPhoneNo());
                        System.out.printf("\nEmail: %s",student.getEmail());
                        System.out.println(" STUDENT COURSE ");
                        System.out.printf("\nCourse Name: %s",studentCourse.getCourseName());
                        System.out.printf("\nCourse Code: %s",studentCourse.getCourseCode());
                        System.out.printf("\nDepartment: %s",studentCourse.getDepartment());
                        break;
                     case 4:
                        firstOption = 1;
                        break;
                     default:
                        System.out.println("\nWrong Option!\n");
                        break;
                  } 
               } while(option != 4);
               
               break;
            case 2:
               break; 
         }
      } while(firstOption < 1 || firstOption > 2);
      
      scan.close();
   }
}