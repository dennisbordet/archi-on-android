package fr.univ.nantes.archi

import android.R.attr.label
import android.R.attr.password
import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.StrokeCap.Companion.Butt
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import fr.univ.nantes.core.ui.ArchiTPTheme
import fr.univ.nantes.core.ui.Purple40

@Composable
fun LoginScreen(
    onLogin: (String, String) -> Unit,
    modifier: Modifier = Modifier
) {
    val (username, setUsername) = rememberSaveable { mutableStateOf("") }
    val (password, setPassword) = rememberSaveable { mutableStateOf("") }

    LoginScreenStateless(modifier, username, setUsername, password, setPassword, onLogin)
}

@Composable
private fun LoginScreenStateless(
    modifier: Modifier,
    username: String,
    setUsername: (String) -> Unit,
    password: String,
    setPassword: (String) -> Unit,
    onLogin: (String, String) -> Unit
) {
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(8.dp, Alignment.CenterVertically),
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        OutlinedTextField(
            value = username,
            onValueChange = { setUsername(it) },
            label = { Text("Username") },
            colors = OutlinedTextFieldDefaults.colors().copy(
                focusedTextColor = Purple40,
                unfocusedTextColor = Purple40,
            )

        )
        OutlinedTextField(
            value = password,
            onValueChange = { setPassword(it) },
            label = { Text("Password") },
            colors = OutlinedTextFieldDefaults.colors().copy(
                focusedTextColor = Purple40,
                unfocusedTextColor = Purple40,
            ),
            visualTransformation = PasswordVisualTransformation()
        )

        Button(
            onClick = {
                Log.d(
                    "LoginScreen",
                    "Login button clicked with username: $username and password: $password"
                )
                onLogin(username, password)
            }
        ) {
            Text("Login")
        }
    }
}


@Preview(showBackground = true)
@Composable
fun LoginScreenPreview() {
    ArchiTPTheme {
        LoginScreenStateless(
            username = "toto",
            setUsername = {},
            password = "toto",
            setPassword = {},
            onLogin = { _, _ -> },
            modifier = Modifier.fillMaxSize()
        )
    }
}