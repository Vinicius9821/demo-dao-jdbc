package application;

import model.dao.DaoFactory;
import model.dao.DepartmentDao;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.util.List;
import java.util.Scanner;

public class Program2 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        DepartmentDao departmentDao = DaoFactory.createDepartmentDao();
        System.out.println("=== TEST 1: DEPARTMENT findById ===");
        Department department = departmentDao.findById(1);
        System.out.println(department);

        System.out.println("\n=== TEST 1: DEPARTMENT findAll ===");
        List<Department> list = departmentDao.findAll();
        for (Department obj : list){
            System.out.println(obj);
        }

        System.out.println("\n=== TEST 4: seller insert ====");
        Department newDepartment = new Department(null, "Music");
        departmentDao.insert(newDepartment);
        System.out.println("Inserted! New id = " + newDepartment.getId());

        System.out.println("\n=== TEST 5: department update ====");
        department = departmentDao.findById(1);
        department.setName("Food");
        departmentDao.update(department);
        System.out.println("Update complete");

        System.out.println("\n=== TEST 6: department delete ====");
        System.out.println("Enter if for delete");
        int id = sc.nextInt();
        departmentDao.deleteById(id);
        System.out.println("Delete completed");

    }

}
