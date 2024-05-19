import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.material3.TextFieldDefaults

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun RegisterScreen(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .requiredWidth(width = 360.dp)
            .requiredHeight(height = 812.dp)
            .background(color = Color.White)
    ) {
        TypeStandard(
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .padding(start = 16.dp, top = 44.dp)
        )
        Box(
            modifier = Modifier
                .align(alignment = Alignment.TopStart)
                .paddingFromBaseline(top = 267.dp)
                .padding(start = 16.dp, end = 16.dp)
        ) {
            OutlinedTextField(
                value = "",
                onValueChange = {},
                label = { Text("username", color = Color(0xff9ba5b7)) },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color(0xff9ba5b7),
                    unfocusedBorderColor = Color(0xff9ba5b7),
                    cursorColor = Color(0xff9ba5b7),
                    textColor = Color.Black,
                    backgroundColor = Color.White
                ),
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(16.dp))
            OutlinedTextField(
                value = "",
                onValueChange = {},
                label = { Text("email", color = Color(0xff9ba5b7)) },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color(0xff9ba5b7),
                    unfocusedBorderColor = Color(0xff9ba5b7),
                    cursorColor = Color(0xff9ba5b7),
                    textColor = Color.Black,
                    backgroundColor = Color.White
                ),
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(16.dp))
            OutlinedTextField(
                value = "",
                onValueChange = {},
                label = { Text("password", color = Color(0xff9ba5b7)) },
                colors = TextFieldDefaults.outlinedTextFieldColors(
                    focusedBorderColor = Color(0xff9ba5b7),
                    unfocusedBorderColor = Color(0xff9ba5b7),
                    cursorColor = Color(0xff9ba5b7),
                    textColor = Color.Black,
                    backgroundColor = Color.White
                ),
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(16.dp))
            SizeRoundedTypePrimaryStateDefault(modifier = Modifier.fillMaxWidth())
        }
        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .padding(top = 104.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = buildAnnotatedString {
                    withStyle(
                        style = SpanStyle(
                            color = Color(0xffff8066),
                            fontSize = 32.sp,
                            fontWeight = FontWeight.Bold
                        )
                    ) { append("Buat") }
                    append(" ")
                    withStyle(
                        style = SpanStyle(
                            color = Color(0xff656565),
                            fontSize = 32.sp,
                            fontWeight = FontWeight.Bold
                        )
                    ) { append("Akun") }
                },
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(horizontal = 29.dp)
            )
            Text(
                text = "Masukkan detail akun anda",
                color = Color(0xff272727),
                style = androidx.compose.ui.text.TextStyle(fontSize = 16.sp),
                textAlign = TextAlign.Center,
                modifier = Modifier.padding(top = 8.dp)
            )
        }
    }
}

@Composable
fun TypeStandard(modifier: Modifier = Modifier) {
    Box(
        modifier = modifier
            .requiredWidth(width = 375.dp)
            .requiredHeight(height = 72.dp)
            .background(color = Color.White)
    )
}

@Composable
fun SizeRoundedTypePrimaryStateDefault(modifier: Modifier = Modifier) {
    Text(
        text = "Daftar",
        color = Color.White,
        fontSize = 16.sp,
        textAlign = TextAlign.Center,
        style = MaterialTheme.typography.titleMedium,
        modifier = modifier
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .fillMaxWidth()
            .background(color = Color(0xffff8066), shape = RoundedCornerShape(5.dp))
    )
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview(widthDp = 360, heightDp = 812)
@Composable
private fun RegisterScreenPreview() {
    RegisterScreen(Modifier)
}
