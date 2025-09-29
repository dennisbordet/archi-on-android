package fr.univ.nantes.data.login

interface LoginRepository {
    @Throws(LoginException.WrongPasswordException::class, LoginException.NotExistingException::class)
    suspend fun authenticateUser(username: String, password: String): User
}