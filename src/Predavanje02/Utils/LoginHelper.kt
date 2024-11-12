package Predavanje02.Utils

import Predavanje02.Classes.Admin
import Predavanje02.Classes.Employee

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