import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttons = arrayOf(button0, button1, button2, button3, button4, button5, button6, button7, button8, button9)

        for (button in buttons) {
            button.setOnClickListener { appendDigit(button.text.toString()) }
        }

        buttonAdd.setOnClickListener { performOperation("+") }
        buttonSubtract.setOnClickListener { performOperation("-") }
        buttonEquals.setOnClickListener { calculateResult() }
        buttonClear.setOnClickListener { clearInput() }
    }

    private fun appendDigit(digit: String) {
        inputField.append(digit)
    }

    private fun performOperation(operator: String) {
        inputField.append(" $operator ")
    }

    private fun calculateResult() {
        val expression = inputField.text.toString()
        val result = evaluateExpression(expression)
        inputField.setText(result.toString())
    }

    private fun evaluateExpression(expression: String): Int {
        val parts = expression.split(" ")
        var currentResult = parts[0].toInt()

        for (i in 1 until parts.size step 2) {
            val operator = parts[i]
            val operand = parts[i + 1].toInt()

            if (operator == "+") {
                currentResult += operand
            } else if (operator == "-") {
                currentResult -= operand
            }
        }

        return currentResult
    }

    private fun clearInput() {
        inputField.text.clear()
    }
}
