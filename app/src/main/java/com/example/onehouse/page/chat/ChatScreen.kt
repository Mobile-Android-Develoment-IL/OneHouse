import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.text.SimpleDateFormat
import java.util.*

@Composable
fun ChatScreen(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(Color(0xFFF5F5F5)) // Warna background yang lebih terang
            .padding(16.dp)
    ) {
        // Menampilkan daftar pesan menggunakan LazyColumn
        LazyColumn(
            modifier = Modifier.weight(1f) // Memenuhi ruang yang tersedia
        ) {
            // Contoh daftar pesan jual beli rumah
            val houseSaleMessages = listOf(
                HouseSaleMessage("Alice", "Selling a beautiful villa in the countryside. Interested?", Date()),
                HouseSaleMessage("Bob", "Looking for a cozy apartment in downtown. Any recommendations?", Date()),
                HouseSaleMessage("Charlie", "Just listed a spacious family home near the beach. Check it out!", Date()),
                HouseSaleMessage("David", "Buying a condo with sea view. Any good offers?", Date()),
                HouseSaleMessage("Eve", "Found a great deal on a penthouse. Contact me for details!", Date())
            )

            items(houseSaleMessages.size) { index ->
                HouseSaleMessageItem(message = houseSaleMessages[index])
            }
        }
    }
}

data class HouseSaleMessage(
    val sender: String,
    val content: String,
    val timestamp: Date
)

@Composable
fun HouseSaleMessageItem(message: HouseSaleMessage) {
    val dateFormat = SimpleDateFormat("HH:mm", Locale.getDefault())
    val formattedTime = dateFormat.format(message.timestamp)

    Card(
        modifier = Modifier
            .fillMaxWidth() // Memenuhi lebar layar
            .padding(vertical = 8.dp, horizontal = 16.dp), // Padding atas dan bawah

        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(Color.White)
    ) {
        Column(
            modifier = Modifier.padding(16.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Box(
                    modifier = Modifier
                        .size(40.dp)
                        .background(MaterialTheme.colorScheme.secondary, RoundedCornerShape(20.dp)),
                    contentAlignment = Alignment.Center
                ) {
                    Text(
                        text = message.sender.take(1).toUpperCase(),
                        color = Color.White,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
                Spacer(modifier = Modifier.width(8.dp))
                Text(
                    text = message.sender,
                    color = MaterialTheme.colorScheme.onSurface,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.weight(1f))
                Text(
                    text = formattedTime,
                    color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.6f),
                    fontSize = 12.sp,
                )
            }
            Spacer(modifier = Modifier.height(8.dp))
            Text(
                text = message.content,
                color = MaterialTheme.colorScheme.onSurface,
                fontSize = 14.sp,
            )
        }
    }
}
