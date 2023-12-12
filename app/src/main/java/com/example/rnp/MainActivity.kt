package com.example.rnp
import android.widget.Button
import android.widget.TextView
import android.view.View
import android.os.Bundle
import android.widget.ImageButton
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.rnp.ui.theme.RNPTheme
import java.util.Random

class MainActivity : ComponentActivity(), View.OnClickListener {
    private lateinit var playerChoice: TextView
    private lateinit var computerChoice: TextView
    private lateinit var result: TextView
    private lateinit var information: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)

        playerChoice = findViewById(R.id.player_choice)
        computerChoice = findViewById(R.id.computer_choice)
        result = findViewById(R.id.result)
        information = findViewById(R.id.informa)

        findViewById<Button>(R.id.button_rock).setOnClickListener(this)
        findViewById<Button>(R.id.button_paper).setOnClickListener(this)
        findViewById<Button>(R.id.button_scissors).setOnClickListener(this)
        findViewById<Button>(R.id.button_info).setOnClickListener(this)
    }

    override fun onClick(view: View?) {

        val player: String
        when (view?.id) {
            R.id.button_rock -> {
                player = "Камень"
                playerChoice.text = "Вы:" + player
            }
            R.id.button_paper -> {
                player = "Бумага"
                playerChoice.text = "Вы:" + player
            }
            R.id.button_scissors -> {
                player = "Ножницы"
                playerChoice.text = "Вы:" + player
            }
            R.id.button_info -> {
                information.text = "Работу выполнили: Людкевич М. ,Гусев Д. ,Сурков Е."
                return
            }
            else -> return
        }

        val random = Random().nextInt(3)
        val computer: String = when (random) {
            0 -> "Камень"
            1 -> "Бумага"
            else -> "Ножницы"
        }
        computerChoice.text = "AI:" + computer

        if (player == computer){
            result.text = "Ничья"
        }
        if (player == "Камень" && computer == "Ножницы" ||
            player == "Бумага" && computer == "Камень" ||
            player == "Ножницы" && computer == "Бумага"){
            result.text = "Вы победили!"
        }
        if (computer == "Камень" && player == "Ножницы" ||
            computer == "Бумага" && player == "Камень" ||
            computer == "Ножницы" && player == "Бумага"){
            result.text = "Вы проиграли("
        }


    }

}

