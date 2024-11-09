package Predavanje02

data class Employee(val name: String, val lastName: String, val role: Role = Role.WORKER) {
    companion object {
        val employees = mutableListOf<Employee>(Employee("Admin", "Admin", Role.ADMIN))
    }

    fun addEmployee(employee: Employee) {
        if(this.role == Role.ADMIN) {
            employees.add(employee)
            println("Employee added successfully")
            employees.forEach{ println("${it.name} ${it.role}") }
        } else {
            throw IllegalAccessException("You don't have permission to add employee")
        }
    }
}