package com.example.karim.tictactoe;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

	private TextView tv_res;
	private boolean turn;
	int winner = -1;
	private Drawable draw ;
	private ArrayList<Button> allBtn;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		tv_res = (TextView) findViewById(R.id.tv_result);
		tv_res.setText("X turn");
		turn = true;
		allBtn = new ArrayList<>();
		allBtn.add((Button) findViewById(R.id.btn1));
		allBtn.add((Button) findViewById(R.id.btn2));
		allBtn.add((Button) findViewById(R.id.btn3));
		allBtn.add((Button) findViewById(R.id.btn4));
		allBtn.add((Button) findViewById(R.id.btn5));
		allBtn.add((Button) findViewById(R.id.btn6));
		allBtn.add((Button) findViewById(R.id.btn7));
		allBtn.add((Button) findViewById(R.id.btn8));
		allBtn.add((Button) findViewById(R.id.btn9));
		draw = allBtn.get(0).getBackground();
	}
	protected void newGame(View view)
	{
		tv_res.setText("X turn");
		for(Button b : allBtn)
		{
			b.setClickable(true);
			b.setText("");
			b.setBackgroundDrawable(draw);
		}
		turn = true;
		winner = -1;
	}
	protected void onClick(View view)
	{
		if(turn)
		{
			((Button) view).setText("X");
			((Button) view).setBackgroundColor(Color.RED);
			tv_res.setText("O turn");
		}
		else
		{
			tv_res.setText("X turn");
			((Button) view).setText("O");
			((Button) view).setBackgroundColor(Color.BLUE);
		}
		((Button) view).setClickable(false);
		turn=!turn;
		check();
		int cnt=0;
		for(Button b :allBtn)
			if(b.getText().toString().compareTo("")!=0)
				cnt++;
		if(cnt==9&&winner==-1)
			tv_res.setText("tie!");
		if(winner!=-1)
		{
			for(Button b : allBtn)
				b.setClickable(false);
			if(winner == 1)
				tv_res.setText("X Wins");
			else
				tv_res.setText("O Wins");
		}
	}
	private  void check()
	{
		int cnt1 = 0, cnt2 = 0, cnt5 = 0, cnt6 = 0, cnt9 = 0, cnt10 = 0, cnt11 = 0, cnt12 = 0, cnt13 = 0, cnt14 = 0, cnt15 = 0, cnt16 = 0 ;
		if (allBtn.get(0).getText().toString().compareTo(allBtn.get(4).getText().toString())==0 &&
				allBtn.get(0).getText().toString().compareTo(allBtn.get(8).getText().toString())==0 &&
				allBtn.get(4).getText().toString().compareTo("")!=0)
		{
			if (allBtn.get(0).getText().toString().compareTo("X")==0)
			{
				winner = 1;
				return;
			}
			else
			{
				winner = 2;
				return;
			}
		}
		else if (allBtn.get(2).getText().toString().compareTo(allBtn.get(4).getText().toString())==0
				&& allBtn.get(2).getText().toString().compareTo(allBtn.get(6).getText().toString())==0 &&
				allBtn.get(4).getText().toString().compareTo("")!=0)
		{
			if (allBtn.get(2).getText().toString().compareTo("X")==0)
			{
				winner = 1;
				return;
			}
			else
			{
				winner = 2;
				return;
			}
		}
		for (int i = 0; i < allBtn.size(); i++)
		{
			if (i % 3 == 0)
			{
				if (allBtn.get(i).getText().toString().compareTo("X")==0)
					cnt1++;
				else if (allBtn.get(i).getText().toString().compareTo("O")==0)
					cnt2++;
				if (cnt1 == 3)
				{
					winner = 1;
					return;
				}
				if (cnt2 == 3)
				{
					winner = 2;
					return;
				}
			}
			else if (i % 3 == 1)
			{
				if (allBtn.get(i).getText().toString().compareTo("X")==0)
					cnt13++;
				else if (allBtn.get(i).getText().toString().compareTo("O")==0)
					cnt14++;
				if (cnt13 == 3)
				{
					winner = 1;
					return;
				}
				if (cnt14 == 3)
				{
					winner = 2;
					return;
				}
			}
			else if (i % 3 == 2)
			{
				if (allBtn.get(i).getText().toString().compareTo("X")==0)
					cnt15++;
				else if (allBtn.get(i).getText().toString().compareTo("O")==0)
					cnt16++;
				if (cnt15 == 3)
				{
					winner = 1;
					return;
				}
				if (cnt16 == 3)
				{
					winner = 2;
					return;
				}
			}
			if (i >= 0 && i <= 2)
			{

				if (allBtn.get(i).getText().toString().compareTo("X")==0)
					cnt5++;
				else if (allBtn.get(i).getText().toString().compareTo("O")==0)
					cnt6++;
				if (cnt5 == 3)
				{
					winner = 1;
					return;
				}
				if (cnt6 == 3)
				{
					winner = 2;
					return;
				}
			}
			if(i >= 3 && i <= 5)
			{
				if (allBtn.get(i).getText().toString().compareTo("X")==0)
					cnt9++;
				else if (allBtn.get(i).getText().toString().compareTo("O")==0)
					cnt10++;
				if (cnt9 == 3)
				{
					winner = 1;
					return;
				}
				if (cnt10 == 3)
				{
					winner = 2;
					return;
				}
			}
			if (i >= 6 && i <= 8)
			{

				if (allBtn.get(i).getText().toString().compareTo("X")==0)
					cnt11++;
				else if (allBtn.get(i).getText().toString().compareTo("O")==0)
					cnt12++;
				if (cnt11 == 3)
				{
					winner = 1;
					return;
				}
				if (cnt12 == 3)
				{
					winner = 2;
					return;
				}
			}
		}
	}
}