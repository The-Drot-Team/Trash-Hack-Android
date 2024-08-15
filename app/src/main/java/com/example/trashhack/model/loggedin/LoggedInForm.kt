package com.example.trashhack.model.loggedin

data class LoggedInUser (
    var fullname: String,
    var email: String,
    var password: String
)

var LoggedInUser_instance = LoggedInUser("", "", "")
/*{
    public lateinit var fullname: String
    public lateinit var email: String
    public lateinit var password: String

    fun setfullname(Fullname: String) {
        fullname = Fullname
    }
    fun getfullname(): String {
        return fullname
    }
    fun setemail(Email: String) {
        email = Email
    }
    fun getemail(): String {
        return email
    }
    fun setpassword(Password: String) {
        password = Password
    }
    fun getpassword(): String {
        return password
    }
}

 */