package fr.univ.nantes.data.login

class LoginRepositoryMockImpl : LoginRepository {
    override suspend fun authenticateUser(
        username: String,
        password: String
    ): User {
        return when {
            username != "admin" -> throw LoginException.NotExistingException
            password != "admin" -> throw LoginException.WrongPasswordException
            else -> User(
                username = "MIAGE qui a bien avancé le tp",
                email = "miage@univ-nantes.fr"
            )
        }
    }
}