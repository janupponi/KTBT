class MainActivity : AppCompatActivity() {
    var outcome=""
    fun decide(){
        val randomnum = (Random.nextInt(0, 8))
        when (randomnum){
            0->outcome="Yes, Go for it!!"
            1->outcome="No, leave it."
            2->outcome="Maybe..."
            3->outcome="Ask again later?"
            4->outcome="Most Probably."
            5->outcome="Think about it again..."
            6->outcome="ABSOLUTELY NOT"
            7->outcome="YES! YES! YES!"
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val Output = findViewById<TextView>(R.id.output)
        val Decide = findViewById<Button>(R.id.button)

        Decide.setOnClickListener{
            decide()
            Output.text=outcome
        }
    }
}
