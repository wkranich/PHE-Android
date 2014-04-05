package org.peerhealthexchange.phemobile.dialogbox;

import org.peerhealthexchange.phemobile.R;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

public class HotlinesDialog extends DialogFragment {
	
	Context context;

	public static HotlinesDialog newInstance(String Hours, String Name,
			int position) {
		HotlinesDialog frag = new HotlinesDialog();

		Bundle args = new Bundle();
		args.putString("hours", Hours);
		args.putString("name", Name);
		args.putInt("position", position);
		frag.setArguments(args);
		return frag;

	}

	public interface HotlinesDialogListener {
		public void onChoiceClick(int which);
	}

	HotlinesDialogListener mListener; // initialize the listener

	// Override the Fragment.onAttach() method to instantiate the
	// NoticeDialogListener
	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		// Verify that the host activity implements the callback interface
		try {
			// Instantiate the NoticeDialogListener so we can send events to the
			// host
			mListener = (HotlinesDialogListener) activity;
		} catch (ClassCastException e) {
			// The activity doesn't implement the interface, throw exception
			throw new ClassCastException(activity.toString()
					+ " must implement NoticeDialogListener");
		}
	}

	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		Typeface myTypeface = Typeface.createFromAsset(getActivity().getAssets(),
				"fonts/HelveticaNeue-Light.otf");
		String Hours = getArguments().getString("hours");
		String Name = getArguments().getString("name");
		final int position = getArguments().getInt("position");

		AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
		TextView longText = new TextView(getActivity());
		longText.setText(Name+"\n"+Hours);
		longText.setTextAppearance(getActivity(), android.R.style.TextAppearance_DeviceDefault_DialogWindowTitle);
		longText.setTypeface(myTypeface);
		longText.setGravity(Gravity.CENTER);
		LayoutInflater inflater = getActivity().getLayoutInflater();

		// set the "title" to the hours
		View dialogView = inflater.inflate(R.layout.custom_maps_dialog, null);
		// ((TextView) dialogView.findViewById(R.id.hoursTxt)).setText(Hours);

		builder.setCustomTitle(longText).setItems(R.array.hotDiagOpts,
				new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						// there will only be one case, so which will always be
						// zero, thus we can get the position by adding position
						// to which
						mListener.onChoiceClick(which + position);
					}
				});
		return builder.create();

	}
}
