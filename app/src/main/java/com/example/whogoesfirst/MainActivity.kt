package com.example.whogoesfirst

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var team1Input: EditText
    private lateinit var team2Input: EditText
    private lateinit var teamSelectButton: Button
    private lateinit var resultLabel: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        team1Input = findViewById(R.id.team1_input)
        team2Input = findViewById(R.id.team2_input)
        teamSelectButton = findViewById(R.id.team_select_button)
        resultLabel = findViewById(R.id.result_label)

        teamSelectButton.setOnClickListener {
            // get the two team names
            val team1Name = team1Input.text.toString()
            val team2Name = team2Input.text.toString()
            if (team1Name.isEmpty() || team2Name.isEmpty()) {
                // both fields must be filled out to proceed
                Toast.makeText(this, "Please enter two team names!", Toast.LENGTH_LONG).show()
            } else {
                // choose a random team between the two
                val chosenTeam = listOf(team1Name, team2Name).random()
                // update resultLabel TextView to display the chosen team
                resultLabel.text = chosenTeam
            }
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}