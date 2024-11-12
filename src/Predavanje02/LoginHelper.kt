package Predavanje02

import Predavanje02.Employee.Companion.employees

class LoginHelper {
    fun performLogin(username: String, onFailure: () -> Unit, onLogin: (Employee) -> Unit) {
        val employee = Admin.getEmployees().find { it.name == username }
        if (employee != null) {
            onLogin(employee)
        } else {
            onFailure()
        }
    }
}