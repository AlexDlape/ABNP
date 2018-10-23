/**Congratulations
 Hello there. 🎖
 You have done a great job after all. You have done everything very well. You have used the tools very well to implement the project.
 There are many good points that I couldn't mention. But I would like to mention that you have put a good amount of thoughts in this project you have given attention to very tiny details in this app; The app is eye-catching: great taste in picking colors, fit values for padding and margins. You should be proud. Keep the good work up.
 I enjoyed this Project a lot. I tried to go a step further in my coding skills, and I tried to develop an app that is visually attractive.
 It is really obvious form your work that you have been enjoying working in this project and you was challenging yourself. And I enjoyed reviewing your project it. Great work. Keep this up.
 In terms of coding, I would like the reviewer to check why when I press the "Reset" button, the app goes automatically to "Question 9".
 It happen because of this line of code dataText.requestFocus();. Please check my notes.
 Please, take a look on my notes in code review section, where I provided more suggestion and hints to improve your code.
 Good luck!
 If you have any comment for me about this review, please leave it in the feedback.*/

package com.example.android.archiprize;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public int score = 0;

    /**Suggestion
    Fields or methods, that are not going to be used outside class scope, should be declared private unless there is a good reason for not doing so. So, the rule is: All variables or methods should be private unless they absolutely need to be public and there are good reasons to do so.
    Check out these links:
    Fields should usually be private
    Why do we need private variables?*/

    private CheckBox mQuestion2a;
    private CheckBox mQuestion2b;
    private CheckBox mQuestion2c;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**Suggestion
    Try to add more descriptive comments to your code explaining what your code does, what its purpose is, or what your intention was when your wrote this code.
    Are there any comments worth adding to help you remember something when you come back later or to make it easier for others to work with you? Comments does increase the code readability.
    It's highly recommend to follow Google Java Style and use Javadoc standard comments*/

    public void buttonEvaluate(View view) {
        score = 0;
        int numberText;
        RadioGroup dataRadio;
        RadioButton dataRadioButton;

    EditText dataText = (EditText) findViewById(R.id.edit1);
        if (dataText.getText().toString().toLowerCase().trim().contains("bauhaus")) {

            /**Suggestion
             Great work for trying to give user more flexibility in typing their answers. But there is alternative ways or more helpful function you should reconsider using them.
             As you know, Android OS is open platform, there are plenty of soft keyboards with different configurations.
             You can't predict that the user will enter the same answer in same upper or lower case like yours or not.
             Use equalsIgnoreCase() instead of equals(). DOCS
             For example:
             "five".equalsIgnoreCase("fIvE");  // this returns true.
*/

             score += 1;
        dataText.setBackgroundColor(0x2200FF00);
        dataText.setText(R.string.question1b);
    } else {
        dataText.setBackgroundColor(0x22FF0000);
    }

        dataText = (EditText) findViewById(R.id.edit2);
        if (dataText.getText().toString().toLowerCase().trim().contains("xiv")) {
            score += 1;
            dataText.setBackgroundColor(0x2200FF00);
            dataText.setText(R.string.question2);
        } else {
            dataText.setBackgroundColor(0x22FF0000);
        }

        dataRadio = (RadioGroup) findViewById(R.id.radio1);

        switch (dataRadio.getCheckedRadioButtonId()) {
            case R.id.radio1c:
                dataRadioButton = (RadioButton) findViewById(R.id.radio1c);
                dataRadioButton.setBackgroundColor(0x2200FF00);
                score += 1;
                break;
            case R.id.radio1b:
                dataRadioButton = (RadioButton) findViewById(R.id.radio1b);
                dataRadioButton.setBackgroundColor(0x22FF0000);
                break;
            case R.id.radio1a:
                dataRadioButton = (RadioButton) findViewById(R.id.radio1a);
                dataRadioButton.setBackgroundColor(0x22FF0000);
                break;
            default:
                dataRadioButton = (RadioButton) findViewById(R.id.radio1c);
                dataRadioButton.setBackgroundColor(0x22FF0000);
                dataRadioButton = (RadioButton) findViewById(R.id.radio1b);
                dataRadioButton.setBackgroundColor(0x22FF0000);
                dataRadioButton = (RadioButton) findViewById(R.id.radio1a);
                dataRadioButton.setBackgroundColor(0x22FF0000);
                break;
        }

        mQuestion2a = (CheckBox) findViewById(R.id.radio2a);
        mQuestion2b = (CheckBox) findViewById(R.id.radio2b);
        mQuestion2c = (CheckBox) findViewById(R.id.radio2c);
        if (mQuestion2a.isChecked() && mQuestion2b.isChecked() && mQuestion2c.isChecked()) {
            score += 0;
            mQuestion2a.setBackgroundColor(0x22FF0000);

            /**Awesome
            Nice touch. for changing the background of the choices based on user's answers.
            I would like to mention that you have picked great colors that matches the colors you used with other views.*/

            mQuestion2b.setBackgroundColor(0x22FF0000);
            mQuestion2c.setBackgroundColor(0x22FF0000);
        }else if (mQuestion2a.isChecked() && mQuestion2c.isChecked()) {
        score += 0;
            mQuestion2a.setBackgroundColor(0x22FF0000);
            mQuestion2b.setBackgroundColor(0x22FF0000);
            mQuestion2c.setBackgroundColor(0x22FF0000);
        }else if (mQuestion2b.isChecked() && mQuestion2c.isChecked()) {
            score += 0;
            mQuestion2a.setBackgroundColor(0x22FF0000);
            mQuestion2b.setBackgroundColor(0x22FF0000);
            mQuestion2c.setBackgroundColor(0x22FF0000);
        }else if (mQuestion2a.isChecked() && mQuestion2b.isChecked()) {
            score += 1;
            mQuestion2a.setBackgroundColor(0x2200FF00);
            mQuestion2b.setBackgroundColor(0x2200FF00);
            mQuestion2c.setBackgroundColor(0x2200FF00);
        }else if (mQuestion2a.isChecked()) {
            score += 0;
            mQuestion2a.setBackgroundColor(0x22FF0000);
            mQuestion2b.setBackgroundColor(0x22FF0000);
            mQuestion2c.setBackgroundColor(0x22FF0000);
        }else if (mQuestion2b.isChecked()) {
            score += 0;
            mQuestion2a.setBackgroundColor(0x22FF0000);
            mQuestion2b.setBackgroundColor(0x22FF0000);
            mQuestion2c.setBackgroundColor(0x22FF0000);
        }else if (mQuestion2c.isChecked()) {
            score += 0;
            mQuestion2a.setBackgroundColor(0x22FF0000);
            mQuestion2b.setBackgroundColor(0x22FF0000);
            mQuestion2c.setBackgroundColor(0x22FF0000);
    }else {
            score += 0;
            mQuestion2a.setBackgroundColor(0x22FF0000);
            mQuestion2b.setBackgroundColor(0x22FF0000);
            mQuestion2c.setBackgroundColor(0x22FF0000);
        }

        dataRadio = (RadioGroup) findViewById(R.id.radio3);

        switch (dataRadio.getCheckedRadioButtonId()) {
            case R.id.radio3b:
                dataRadioButton = (RadioButton) findViewById(R.id.radio3b);
                dataRadioButton.setBackgroundColor(0x2200FF00);
                score += 1;
                break;
            case R.id.radio3a:
                dataRadioButton = (RadioButton) findViewById(R.id.radio3a);
                dataRadioButton.setBackgroundColor(0x22FF0000);
                break;
            case R.id.radio3c:
                dataRadioButton = (RadioButton) findViewById(R.id.radio3c);
                dataRadioButton.setBackgroundColor(0x22FF0000);
                break;
            default:
                dataRadioButton = (RadioButton) findViewById(R.id.radio3c);
                dataRadioButton.setBackgroundColor(0x22FF0000);
                dataRadioButton = (RadioButton) findViewById(R.id.radio3b);
                dataRadioButton.setBackgroundColor(0x22FF0000);
                dataRadioButton = (RadioButton) findViewById(R.id.radio3a);
                dataRadioButton.setBackgroundColor(0x22FF0000);
                break;
        }

        dataRadio = (RadioGroup) findViewById(R.id.radio4);

        switch (dataRadio.getCheckedRadioButtonId()) {
            case R.id.radio4c:
                dataRadioButton = (RadioButton) findViewById(R.id.radio4c);
                dataRadioButton.setBackgroundColor(0x2200FF00);
                score += 1;
                break;
            case R.id.radio4b:
                dataRadioButton = (RadioButton) findViewById(R.id.radio4b);
                dataRadioButton.setBackgroundColor(0x22FF0000);
                break;
            case R.id.radio4a:
                dataRadioButton = (RadioButton) findViewById(R.id.radio4a);
                dataRadioButton.setBackgroundColor(0x22FF0000);
                break;
            default:
                dataRadioButton = (RadioButton) findViewById(R.id.radio4c);
                dataRadioButton.setBackgroundColor(0x22FF0000);
                dataRadioButton = (RadioButton) findViewById(R.id.radio4b);
                dataRadioButton.setBackgroundColor(0x22FF0000);
                dataRadioButton = (RadioButton) findViewById(R.id.radio4a);
                dataRadioButton.setBackgroundColor(0x22FF0000);
                break;
        }

        dataRadio = (RadioGroup) findViewById(R.id.radio5);

        switch (dataRadio.getCheckedRadioButtonId()) {
            case R.id.radio5a:
                dataRadioButton = (RadioButton) findViewById(R.id.radio5a);
                dataRadioButton.setBackgroundColor(0x2200FF00);
                score += 1;
                break;
            case R.id.radio5b:
                dataRadioButton = (RadioButton) findViewById(R.id.radio5b);
                dataRadioButton.setBackgroundColor(0x22FF0000);
                break;
            default:
                dataRadioButton = (RadioButton) findViewById(R.id.radio5a);
                dataRadioButton.setBackgroundColor(0x22FF0000);
                dataRadioButton = (RadioButton) findViewById(R.id.radio5b);
                dataRadioButton.setBackgroundColor(0x22FF0000);
                break;
        }

        dataRadio = (RadioGroup) findViewById(R.id.radio6);

        switch (dataRadio.getCheckedRadioButtonId()) {
            case R.id.radio6b:
                dataRadioButton = (RadioButton) findViewById(R.id.radio6b);
                dataRadioButton.setBackgroundColor(0x2200FF00);
                score += 1;
                break;
            case R.id.radio6a:
                dataRadioButton = (RadioButton) findViewById(R.id.radio6a);
                dataRadioButton.setBackgroundColor(0x22FF0000);
                break;
            case R.id.radio6c:
                dataRadioButton = (RadioButton) findViewById(R.id.radio6c);
                dataRadioButton.setBackgroundColor(0x22FF0000);
                break;
            default:
                dataRadioButton = (RadioButton) findViewById(R.id.radio6c);
                dataRadioButton.setBackgroundColor(0x22FF0000);
                dataRadioButton = (RadioButton) findViewById(R.id.radio6b);
                dataRadioButton.setBackgroundColor(0x22FF0000);
                dataRadioButton = (RadioButton) findViewById(R.id.radio6a);
                dataRadioButton.setBackgroundColor(0x22FF0000);
                break;
        }

        dataRadio = (RadioGroup) findViewById(R.id.radio7);

        switch (dataRadio.getCheckedRadioButtonId()) {
            case R.id.radio7c:
                dataRadioButton = (RadioButton) findViewById(R.id.radio7c);
                dataRadioButton.setBackgroundColor(0x2200FF00);
                score += 1;
                break;
            case R.id.radio7b:
                dataRadioButton = (RadioButton) findViewById(R.id.radio7b);
                dataRadioButton.setBackgroundColor(0x22FF0000);
                break;
            case R.id.radio7a:
                dataRadioButton = (RadioButton) findViewById(R.id.radio7a);
                dataRadioButton.setBackgroundColor(0x22FF0000);
                break;
            default:
                dataRadioButton = (RadioButton) findViewById(R.id.radio7c);
                dataRadioButton.setBackgroundColor(0x22FF0000);
                dataRadioButton = (RadioButton) findViewById(R.id.radio7b);
                dataRadioButton.setBackgroundColor(0x22FF0000);
                dataRadioButton = (RadioButton) findViewById(R.id.radio7a);
                dataRadioButton.setBackgroundColor(0x22FF0000);
                break;
        }

        dataRadio = (RadioGroup) findViewById(R.id.radio10);

        switch (dataRadio.getCheckedRadioButtonId()) {
            case R.id.radio10a:
                dataRadioButton = (RadioButton) findViewById(R.id.radio10a);
                dataRadioButton.setBackgroundColor(0x2200FF00);
                score += 1;
                break;
            case R.id.radio10b:
                dataRadioButton = (RadioButton) findViewById(R.id.radio10b);
                dataRadioButton.setBackgroundColor(0x22FF0000);
                break;
            case R.id.radio10c:
                dataRadioButton = (RadioButton) findViewById(R.id.radio10c);
                dataRadioButton.setBackgroundColor(0x22FF0000);
                break;
            default:
                dataRadioButton = (RadioButton) findViewById(R.id.radio10c);
                dataRadioButton.setBackgroundColor(0x22FF0000);
                dataRadioButton = (RadioButton) findViewById(R.id.radio10b);
                dataRadioButton.setBackgroundColor(0x22FF0000);
                dataRadioButton = (RadioButton) findViewById(R.id.radio10a);
                dataRadioButton.setBackgroundColor(0x22FF0000);
                break;
        }

        Float scoreFinal = Float.parseFloat(String.valueOf(score));
        scoreFinal = scoreFinal / 10;
        scoreFinal = scoreFinal * 100;

        Toast.makeText(this, "Your score is: " + String.valueOf(score) + " points\nYour rate is " + Math.round(scoreFinal) + " %", Toast.LENGTH_SHORT).show();
    }

    public void buttonReset(View view) {

        /**Suggestion
         You have did a great job here. But There is another way to reset the activity by restarting this activity again.
         When you restart it, this activity gets destroyed and re-created again. Hence the activity loss its state of current values.
         final Intent resetIntent = new Intent(this, MainActivity.class);
         startActivity(resetIntent);*/

        score = 0;
        RadioGroup dataRadio;
        RadioButton dataRadioButton;
        EditText dataText;

        dataText = (EditText) findViewById(R.id.edit1);
        dataText.setText("");
        dataText.setBackgroundColor(0x313131);
        dataRadio = (RadioGroup) findViewById(R.id.radio1);
        dataRadio.clearCheck();
        mQuestion2a = (CheckBox) findViewById(R.id.radio2a);
        mQuestion2a.setChecked(false);
        mQuestion2b = (CheckBox) findViewById(R.id.radio2b);
        mQuestion2b.setChecked(false);
        mQuestion2c = (CheckBox) findViewById(R.id.radio2c);
        mQuestion2c.setChecked(false);
        dataRadio = (RadioGroup) findViewById(R.id.radio3);
        dataRadio.clearCheck();
        dataRadio = (RadioGroup) findViewById(R.id.radio4);
        dataRadio.clearCheck();
        dataRadio = (RadioGroup) findViewById(R.id.radio5);
        dataRadio.clearCheck();
        dataRadio = (RadioGroup) findViewById(R.id.radio6);
        dataRadio.clearCheck();
        dataRadio = (RadioGroup) findViewById(R.id.radio7);
        dataRadio.clearCheck();
        dataText = (EditText) findViewById(R.id.edit2);
        dataText.setText("");
        dataText.setBackgroundColor(0x313131);
        dataRadio = (RadioGroup) findViewById(R.id.radio10);
        dataRadio.clearCheck();


        dataRadioButton = (RadioButton) findViewById(R.id.radio1a);
        dataRadioButton.setBackgroundColor(0x313131);
        dataRadioButton = (RadioButton) findViewById(R.id.radio1b);
        dataRadioButton.setBackgroundColor(0x313131);
        dataRadioButton = (RadioButton) findViewById(R.id.radio1c);
        dataRadioButton.setBackgroundColor(0x313131);

        mQuestion2a = (CheckBox) findViewById(R.id.radio2a);
        mQuestion2a.setBackgroundColor(0x313131);
        mQuestion2b = (CheckBox) findViewById(R.id.radio2b);
        mQuestion2b.setBackgroundColor(0x313131);
        mQuestion2c = (CheckBox) findViewById(R.id.radio2c);
        mQuestion2c.setBackgroundColor(0x313131);

        dataRadioButton = (RadioButton) findViewById(R.id.radio3a);
        dataRadioButton.setBackgroundColor(0x313131);
        dataRadioButton = (RadioButton) findViewById(R.id.radio3b);
        dataRadioButton.setBackgroundColor(0x313131);
        dataRadioButton = (RadioButton) findViewById(R.id.radio3c);
        dataRadioButton.setBackgroundColor(0x313131);

        dataRadioButton = (RadioButton) findViewById(R.id.radio4a);
        dataRadioButton.setBackgroundColor(0x313131);
        dataRadioButton = (RadioButton) findViewById(R.id.radio4b);
        dataRadioButton.setBackgroundColor(0x313131);
        dataRadioButton = (RadioButton) findViewById(R.id.radio4c);
        dataRadioButton.setBackgroundColor(0x313131);

        dataRadioButton = (RadioButton) findViewById(R.id.radio5a);
        dataRadioButton.setBackgroundColor(0x313131);
        dataRadioButton = (RadioButton) findViewById(R.id.radio5b);
        dataRadioButton.setBackgroundColor(0x313131);

        dataRadioButton = (RadioButton) findViewById(R.id.radio6a);
        dataRadioButton.setBackgroundColor(0x313131);
        dataRadioButton = (RadioButton) findViewById(R.id.radio6b);
        dataRadioButton.setBackgroundColor(0x313131);
        dataRadioButton = (RadioButton) findViewById(R.id.radio6c);
        dataRadioButton.setBackgroundColor(0x313131);

        dataRadioButton = (RadioButton) findViewById(R.id.radio7a);
        dataRadioButton.setBackgroundColor(0x313131);
        dataRadioButton = (RadioButton) findViewById(R.id.radio7b);
        dataRadioButton.setBackgroundColor(0x313131);
        dataRadioButton = (RadioButton) findViewById(R.id.radio7c);
        dataRadioButton.setBackgroundColor(0x313131);

        dataRadioButton = (RadioButton) findViewById(R.id.radio10a);
        dataRadioButton.setBackgroundColor(0x313131);
        dataRadioButton = (RadioButton) findViewById(R.id.radio10b);
        dataRadioButton.setBackgroundColor(0x313131);
        dataRadioButton = (RadioButton) findViewById(R.id.radio10c);
        dataRadioButton.setBackgroundColor(0x313131);

        dataText.requestFocus();

        /**Suggestion
        For your question:
        I would like the reviewer to check why when I press the "Reset" button, the app goes automatically to "Question 9".
                This happens because of this line. requestFocus() simply mean take user attention to this view. You could fix this be deleting this line.
                You could read that in the docs:*/

    }
}