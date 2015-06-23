package com.example.hw3_0320;

import android.support.v4.app.Fragment;
import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
/**
 * Home Work 4.
 * Program name : simple calculator.
 * Developed date : 03/25/14 
 */
public class MainActivity extends Activity implements OnClickListener {

	String presentText = "";
	int resultValue = 0;
	int firstValue = 0;
	int secondValue = 0;
	boolean onOperator = false;

	TextView result;
	Button clear;
	Button num0, num1, num2, num3, num4, num5, num6, num7, num8, num9;
	Button plus, minus, multi, divide, equal;

	// define button and TextView

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		result = (TextView) findViewById(R.id.resultView);
		num0 = (Button) findViewById(R.id.num0);
		num1 = (Button) findViewById(R.id.num1);
		num2 = (Button) findViewById(R.id.num2);
		num3 = (Button) findViewById(R.id.num3);
		num4 = (Button) findViewById(R.id.num4);
		num5 = (Button) findViewById(R.id.num5);
		num6 = (Button) findViewById(R.id.num6);
		num7 = (Button) findViewById(R.id.num7);
		num8 = (Button) findViewById(R.id.num8);
		num9 = (Button) findViewById(R.id.num9);
		clear = (Button) findViewById(R.id.clear);
		plus = (Button) findViewById(R.id.plus);
		minus = (Button) findViewById(R.id.minus);
		multi = (Button) findViewById(R.id.multi);
		divide = (Button) findViewById(R.id.divide);
		equal = (Button) findViewById(R.id.equal);
		// create object of calculator button and textView

		num0.setOnClickListener(this);
		num1.setOnClickListener(this);
		num2.setOnClickListener(this);
		num3.setOnClickListener(this);
		num4.setOnClickListener(this);
		num5.setOnClickListener(this);
		num6.setOnClickListener(this);
		num7.setOnClickListener(this);
		num8.setOnClickListener(this);
		num9.setOnClickListener(this);
		clear.setOnClickListener(this);
		plus.setOnClickListener(this);
		minus.setOnClickListener(this);
		multi.setOnClickListener(this);
		divide.setOnClickListener(this);
		equal.setOnClickListener(this);
	}

	public void onClick(View view) {
		// if user enter button, event is occurred
		if (view.getId() == num0.getId()) {
			onOperator = false;
			presentText += "0";
			result.setText(presentText);
		} else if (view.getId() == num1.getId()) {
			onOperator = false;
			presentText += "1";
			result.setText(presentText);
		} else if (view.getId() == num2.getId()) {
			onOperator = false;
			presentText += "2";
			result.setText(presentText);
		} else if (view.getId() == num3.getId()) {
			onOperator = false;
			presentText += "3";
			result.setText(presentText);
		} else if (view.getId() == num4.getId()) {
			onOperator = false;
			presentText += "4";
			result.setText(presentText);
		} else if (view.getId() == num5.getId()) {
			onOperator = false;
			presentText += "5";
			result.setText(presentText);
		} else if (view.getId() == num6.getId()) {
			onOperator = false;
			presentText += "6";
			result.setText(presentText);
		} else if (view.getId() == num7.getId()) {
			onOperator = false;
			presentText += "7";
			result.setText(presentText);
		} else if (view.getId() == num8.getId()) {
			onOperator = false;
			presentText += "8";
			result.setText(presentText);
		} else if (view.getId() == num9.getId()) {
			onOperator = false;
			presentText += "9";
			result.setText(presentText);
		}
		/*
		 * If user entered number button zero through nine, Numbers are
		 * represented on textView
		 */
		else if (view.getId() == clear.getId()) {
			onOperator = false;
			presentText = "";
			result.setText(presentText);
		}
		/*
		 * If user entered clear button, TextView was cleared
		 */

		else if (onOperator == false && presentText.length() != 0) {
			/*
			 * If operator click more twice or first input is operator, Program
			 * represent error message through Toast message.
			 */

			if (view.getId() == plus.getId()) {
				/*
				 * Plus Operator : If user entered first operator, Operator is
				 * added at presentText value(String type) But user entered
				 * second operator, values at presetText calculate. (만약 첫번째
				 * 오퍼레이터가 들어오면, presentText라는 스트링 값에 연산자가 추가됩니다. 그러나 두번째 오퍼레이터
				 * 인풋이 들어오면, presentText 스트링을 탐색하여, 해당 연산자로 계산을 처리하여 줍니다.)
				 */
				onOperator = true;
				if (presentText.contains("+")) {
					int indexOfOp = presentText.indexOf("+");
					firstValue = Integer.parseInt(presentText.substring(0,
							indexOfOp));
					secondValue = Integer.parseInt(presentText.substring(
							indexOfOp + 1, presentText.length()));
					resultValue = firstValue + secondValue;
					presentText = "";
					presentText = Integer.toString(resultValue) + "+";
					result.setText(presentText);
				} else if (presentText.contains("-")) {
					int indexOfOp = presentText.indexOf("-");
					firstValue = Integer.parseInt(presentText.substring(0,
							indexOfOp));
					secondValue = Integer.parseInt(presentText.substring(
							indexOfOp + 1, presentText.length()));
					resultValue = firstValue - secondValue;
					presentText = "";
					presentText = Integer.toString(resultValue) + "+";
					result.setText(presentText);
				} else if (presentText.contains("×")) {
					int indexOfOp = presentText.indexOf("×");
					firstValue = Integer.parseInt(presentText.substring(0,
							indexOfOp));
					secondValue = Integer.parseInt(presentText.substring(
							indexOfOp + 1, presentText.length()));
					resultValue = firstValue * secondValue;
					presentText = "";
					presentText = Integer.toString(resultValue) + "+";
					result.setText(presentText);
				} else if (presentText.contains("÷")) {
					int indexOfOp = presentText.indexOf("÷");
					firstValue = Integer.parseInt(presentText.substring(0,
							indexOfOp));
					secondValue = Integer.parseInt(presentText.substring(
							indexOfOp + 1, presentText.length()));
					resultValue = firstValue / secondValue;
					presentText = "";
					presentText = Integer.toString(resultValue) + "+";
					result.setText(presentText);
				} else {
					presentText += "+";
					result.setText(presentText);
				}
			} else if (view.getId() == minus.getId()) {
				/*
				 * Minus Operator : Same with plus operator.
				 */
				onOperator = true;
				if (presentText.contains("+")) {
					int indexOfOp = presentText.indexOf("+");

					firstValue = Integer.parseInt(presentText.substring(0,
							indexOfOp));
					secondValue = Integer.parseInt(presentText.substring(
							indexOfOp + 1, presentText.length()));
					resultValue = firstValue + secondValue;
					presentText = "";
					presentText = Integer.toString(resultValue) + "-";
					result.setText(presentText);
				} else if (presentText.contains("-")) {
					int indexOfOp = presentText.indexOf("-");

					firstValue = Integer.parseInt(presentText.substring(0,
							indexOfOp));
					secondValue = Integer.parseInt(presentText.substring(
							indexOfOp + 1, presentText.length()));
					resultValue = firstValue - secondValue;
					presentText = "";
					presentText = Integer.toString(resultValue) + "-";
					result.setText(presentText);
				} else if (presentText.contains("×")) {
					int indexOfOp = presentText.indexOf("×");

					firstValue = Integer.parseInt(presentText.substring(0,
							indexOfOp));
					secondValue = Integer.parseInt(presentText.substring(
							indexOfOp + 1, presentText.length()));
					resultValue = firstValue * secondValue;
					presentText = "";
					presentText = Integer.toString(resultValue) + "-";
					result.setText(presentText);
				} else if (presentText.contains("÷")) {
					int indexOfOp = presentText.indexOf("÷");

					firstValue = Integer.parseInt(presentText.substring(0,
							indexOfOp));
					secondValue = Integer.parseInt(presentText.substring(
							indexOfOp + 1, presentText.length()));
					resultValue = firstValue / secondValue;
					presentText = "";
					presentText = Integer.toString(resultValue) + "-";
					result.setText(presentText);
				} else {
					onOperator = true;
					presentText += "-";
					result.setText(presentText);
				}
			} else if (view.getId() == multi.getId()) {
				/*
				 * Multiplication Operator : Same with plus operator.
				 */
				onOperator = true;
				if (presentText.contains("+")) {
					int indexOfOp = presentText.indexOf("+");

					firstValue = Integer.parseInt(presentText.substring(0,
							indexOfOp));
					secondValue = Integer.parseInt(presentText.substring(
							indexOfOp + 1, presentText.length()));
					resultValue = firstValue + secondValue;
					presentText = "";
					presentText = Integer.toString(resultValue) + "×";
					result.setText(presentText);
				} else if (presentText.contains("-")) {
					int indexOfOp = presentText.indexOf("-");

					firstValue = Integer.parseInt(presentText.substring(0,
							indexOfOp));
					secondValue = Integer.parseInt(presentText.substring(
							indexOfOp + 1, presentText.length()));
					resultValue = firstValue - secondValue;
					presentText = "";
					presentText = Integer.toString(resultValue) + "×";
					result.setText(presentText);
				} else if (presentText.contains("×")) {
					int indexOfOp = presentText.indexOf("×");

					firstValue = Integer.parseInt(presentText.substring(0,
							indexOfOp));
					secondValue = Integer.parseInt(presentText.substring(
							indexOfOp + 1, presentText.length()));
					resultValue = firstValue * secondValue;
					presentText = "";
					presentText = Integer.toString(resultValue) + "×";
					result.setText(presentText);
				} else if (presentText.contains("÷")) {

					int indexOfOp = presentText.indexOf("÷");

					firstValue = Integer.parseInt(presentText.substring(0,
							indexOfOp));
					secondValue = Integer.parseInt(presentText.substring(
							indexOfOp + 1, presentText.length()));
					resultValue = firstValue / secondValue;
					presentText = "";
					presentText = Integer.toString(resultValue) + "×";
					result.setText(presentText);
				} else {
					onOperator = true;
					presentText += "×";
					result.setText(presentText);
				}
			} else if (view.getId() == divide.getId()) {
				/*
				 * Divide Operator : Same with plus operator.
				 */
				onOperator = true;
				if (presentText.contains("+")) {
					int indexOfOp = presentText.indexOf("+");

					firstValue = Integer.parseInt(presentText.substring(0,
							indexOfOp));
					secondValue = Integer.parseInt(presentText.substring(
							indexOfOp + 1, presentText.length()));
					resultValue = firstValue + secondValue;
					presentText = "";
					presentText = Integer.toString(resultValue) + "÷";
					result.setText(presentText);
				} else if (presentText.contains("-")) {
					int indexOfOp = presentText.indexOf("-");

					firstValue = Integer.parseInt(presentText.substring(0,
							indexOfOp));
					secondValue = Integer.parseInt(presentText.substring(
							indexOfOp + 1, presentText.length()));
					resultValue = firstValue - secondValue;
					presentText = "";
					presentText = Integer.toString(resultValue) + "÷";
					result.setText(presentText);
				} else if (presentText.contains("×")) {
					int indexOfOp = presentText.indexOf("×");

					firstValue = Integer.parseInt(presentText.substring(0,
							indexOfOp));
					secondValue = Integer.parseInt(presentText.substring(
							indexOfOp + 1, presentText.length()));
					resultValue = firstValue * secondValue;
					presentText = "";
					presentText = Integer.toString(resultValue) + "÷";
					result.setText(presentText);
				} else if (presentText.contains("÷")) {
					int indexOfOp = presentText.indexOf("÷");

					firstValue = Integer.parseInt(presentText.substring(0,
							indexOfOp));
					secondValue = Integer.parseInt(presentText.substring(
							indexOfOp + 1, presentText.length()));
					resultValue = firstValue / secondValue;
					presentText = "";
					presentText = Integer.toString(resultValue) + "÷";
					result.setText(presentText);
				} else {
					onOperator = true;
					presentText += "÷";
					result.setText(presentText);
				}
			} else if (view.getId() == equal.getId()) {
				/*
				 * If user entered equal operator, values are calculated by
				 * operator. If user entered equal operator without two integer
				 * values, program present error message through toast.
				 */
				onOperator = true;
				if (presentText.contains("+")) {
					onOperator = false;
					int indexOfOp = presentText.indexOf("+");

					firstValue = Integer.parseInt(presentText.substring(0,
							indexOfOp));
					secondValue = Integer.parseInt(presentText.substring(
							indexOfOp + 1, presentText.length()));
					resultValue = firstValue + secondValue;
					presentText = "";
					presentText = Integer.toString(resultValue);
					result.setText(presentText);
					presentText = "";
				} else if (presentText.contains("-")) {
					onOperator = false;
					int indexOfOp = presentText.indexOf("-");

					firstValue = Integer.parseInt(presentText.substring(0,
							indexOfOp));
					secondValue = Integer.parseInt(presentText.substring(
							indexOfOp + 1, presentText.length()));
					resultValue = firstValue - secondValue;
					presentText = "";
					presentText = Integer.toString(resultValue);
					result.setText(presentText);
					presentText = "";
				} else if (presentText.contains("×")) {
					onOperator = false;
					int indexOfOp = presentText.indexOf("×");

					firstValue = Integer.parseInt(presentText.substring(0,
							indexOfOp));
					secondValue = Integer.parseInt(presentText.substring(
							indexOfOp + 1, presentText.length()));
					resultValue = firstValue * secondValue;
					presentText = "";
					presentText = Integer.toString(resultValue);
					result.setText(presentText);
					presentText = "";
				} else if (presentText.contains("÷")) {
					onOperator = false;
					int indexOfOp = presentText.indexOf("÷");

					firstValue = Integer.parseInt(presentText.substring(0,
							indexOfOp));
					secondValue = Integer.parseInt(presentText.substring(
							indexOfOp + 1, presentText.length()));
					resultValue = firstValue / secondValue;
					presentText = "";
					presentText = Integer.toString(resultValue);
					result.setText(presentText);
					presentText = "";
				} else {
					onOperator = false;
					Toast.makeText(
							this,
							"You aren't input operator.\n Please reenter the number",
							Toast.LENGTH_SHORT).show();
				}
			}
		}

		else {
			Toast.makeText(this, "Please input the number", Toast.LENGTH_SHORT)
					.show();
		}

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {

		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main, container,
					false);
			return rootView;
		}
	}

}
