import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.tugas_3_avatar.R

@Composable
fun FaceAvatarScreen() {
    val showNose = remember { mutableStateOf(true) }
    val showEyebrows = remember { mutableStateOf(true) }
    val showMouth = remember { mutableStateOf(true) }
    val showEyes = remember { mutableStateOf(true) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFFE4E1))
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceBetween
    ) {
        Box(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
            contentAlignment = Alignment.TopCenter
        ) {
            Image(
                painter = painterResource(id = R.drawable.face_0004),
                contentDescription = "Body",
                modifier = Modifier.offset(y = 120.dp)
            )
            if (showEyes.value) {
                Image(
                    painter = painterResource(id = R.drawable.face_0003),
                    contentDescription = "Eyes",
                    modifier = Modifier.offset(y = 310.dp)
                )
            }

            if (showNose.value) {
                Image(
                    painter = painterResource(id = R.drawable.face_0002),
                    contentDescription = "Nose",
                    modifier = Modifier.offset(y = 370.dp)
                )
            }
            if (showEyebrows.value) {
                Image(
                    painter = painterResource(id = R.drawable.face_0001),
                    contentDescription = "Eyebrows",
                    modifier = Modifier.offset(y = 300.dp)
                )
            }
            if (showMouth.value) {
                Image(
                    painter = painterResource(id = R.drawable.face_0000),
                    contentDescription = "Mouth",
                    modifier = Modifier.offset(y = 425.dp)
                )
            }
        }

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 32.dp), // Beri jarak dari bawah layar
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                LabeledCheckbox(label = "Hidung", state = showNose)
                LabeledCheckbox(label = "Alis", state = showEyebrows)
            }
            Spacer(modifier = Modifier.height(16.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                LabeledCheckbox(label = "Mulut", state = showMouth)
                LabeledCheckbox(label = "Mata", state = showEyes)
            }
        }
    }
}

@Composable
fun LabeledCheckbox(label: String, state: MutableState<Boolean>) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Checkbox(
            checked = state.value,
            onCheckedChange = { isChecked ->
                state.value = isChecked
            },
            colors = CheckboxDefaults.colors(
                checkedColor = MaterialTheme.colorScheme.primary,
                uncheckedColor = Color.Gray
            )
        )
        Text(text = label, modifier = Modifier.padding(start = 4.dp))
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreviewFaceAvatar() {
    Surface(modifier = Modifier.fillMaxSize()) {
        FaceAvatarScreen()
    }
}