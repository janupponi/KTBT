class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val input = findViewById<EditText>(R.id.InputET)
        val enter = findViewById<Button>(R.id.EnterBtn)
        val clear = findViewById<Button>(R.id.ClearBtn)
        val output = findViewById<TextView>(R.id.OutputTV)

        enter.setOnClickListener {
            output.text = input.text.toString()
        }

        clear.setOnClickListener {
            output.text = ""
        }

    }
}
