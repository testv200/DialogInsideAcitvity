package in.curium.testandroid;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.RelativeLayout;
import android.widget.ToggleButton;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		ToggleButton toggleButton = (ToggleButton) findViewById(R.id.toggle_dialog_box_id);
		toggleButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View toggleB) {
				boolean isOn = ((ToggleButton) toggleB).isChecked();
				if (isOn) {
					showDialog();
				} else {
					hideDialog();
				}
			}
		});
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
	
	private void showDialog() {
		View opaqueBackground = findViewById(R.id.black_layer_id);
		RelativeLayout dialog = (RelativeLayout) findViewById(R.id.dialog_id);
		opaqueBackground.setVisibility(View.VISIBLE);
		dialog.setVisibility(View.VISIBLE);
	}
	
	private void hideDialog() {
		View opaqueBackground = findViewById(R.id.black_layer_id);
		RelativeLayout dialog = (RelativeLayout) findViewById(R.id.dialog_id);
		opaqueBackground.setVisibility(View.GONE);
		dialog.setVisibility(View.GONE);
	}
	
	@Override
	public void onBackPressed() {
		ToggleButton toggleB = (ToggleButton) findViewById(R.id.toggle_dialog_box_id);
		boolean isOn = toggleB.isChecked();
		if (isOn) {
			toggleB.setChecked(false);
			hideDialog();
		} else {
			super.onBackPressed();
		}
	}
}
