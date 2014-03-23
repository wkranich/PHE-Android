package org.peerhealthexchange.phemobile.dialogbox;

import org.peerhealthexchange.phemobile.R;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

public class MapsDialog extends DialogFragment {

	public static MapsDialog newInstance(String Hours,String Name) {
		MapsDialog frag = new MapsDialog();

		Bundle args = new Bundle();
		args.putString("hours", Hours);
		args.putString("name", Name);
		frag.setArguments(args);
		return frag;

	}

	public interface MapsDialogListener {
		public void onChoiceClick(int which);
	}

	MapsDialogListener mListener; // initialize the listener

	// Override the Fragment.onAttach() method to instantiate the
	// NoticeDialogListener
	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		// Verify that the host activity implements the callback interface
		try {
			// Instantiate the NoticeDialogListener so we can send events to the
			// host
			mListener = (MapsDialogListener) activity;
		} catch (ClassCastException e) {
			// The activity doesn't implement the interface, throw exception
			throw new ClassCastException(activity.toString()
					+ " must implement NoticeDialogListener");
		}
	}

	@Override
	public Dialog onCreateDialog(Bundle savedInstanceState) {
		String Hours = getArguments().getString("hours");
		String Name = getArguments().getString("name");
		
		AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
		LayoutInflater inflater = getActivity().getLayoutInflater();
		
		// set the "title" to the hours
		View dialogView = inflater.inflate(R.layout.custom_maps_dialog, null);
		//((TextView) dialogView.findViewById(R.id.hoursTxt)).setText(Hours);
		
		builder.setTitle(Name).setItems(R.array.mapDiagOpts,
				new DialogInterface.OnClickListener() {

					@Override
					public void onClick(DialogInterface dialog, int which) {
						mListener.onChoiceClick(which);

					}
				});
		return builder.create();

	}
}
