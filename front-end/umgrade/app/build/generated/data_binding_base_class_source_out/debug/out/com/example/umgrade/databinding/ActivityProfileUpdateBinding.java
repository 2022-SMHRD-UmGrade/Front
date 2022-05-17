// Generated by view binder compiler. Do not edit!
package com.example.umgrade.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.umgrade.R;
import de.hdodenhof.circleimageview.CircleImageView;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityProfileUpdateBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final Button btnNickChange;

  @NonNull
  public final ImageButton btnProfileUpdatePre;

  @NonNull
  public final View divider8;

  @NonNull
  public final EditText edtNickChange;

  @NonNull
  public final CircleImageView imgProfileChange;

  @NonNull
  public final LinearLayout linearLayout;

  @NonNull
  public final LinearLayout linearLayout2;

  @NonNull
  public final TextView tvProfileNIckhint;

  @NonNull
  public final TextView tvProfileTitle;

  private ActivityProfileUpdateBinding(@NonNull ConstraintLayout rootView,
      @NonNull Button btnNickChange, @NonNull ImageButton btnProfileUpdatePre,
      @NonNull View divider8, @NonNull EditText edtNickChange,
      @NonNull CircleImageView imgProfileChange, @NonNull LinearLayout linearLayout,
      @NonNull LinearLayout linearLayout2, @NonNull TextView tvProfileNIckhint,
      @NonNull TextView tvProfileTitle) {
    this.rootView = rootView;
    this.btnNickChange = btnNickChange;
    this.btnProfileUpdatePre = btnProfileUpdatePre;
    this.divider8 = divider8;
    this.edtNickChange = edtNickChange;
    this.imgProfileChange = imgProfileChange;
    this.linearLayout = linearLayout;
    this.linearLayout2 = linearLayout2;
    this.tvProfileNIckhint = tvProfileNIckhint;
    this.tvProfileTitle = tvProfileTitle;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityProfileUpdateBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityProfileUpdateBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_profile_update, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityProfileUpdateBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btnNickChange;
      Button btnNickChange = ViewBindings.findChildViewById(rootView, id);
      if (btnNickChange == null) {
        break missingId;
      }

      id = R.id.btnProfileUpdatePre;
      ImageButton btnProfileUpdatePre = ViewBindings.findChildViewById(rootView, id);
      if (btnProfileUpdatePre == null) {
        break missingId;
      }

      id = R.id.divider8;
      View divider8 = ViewBindings.findChildViewById(rootView, id);
      if (divider8 == null) {
        break missingId;
      }

      id = R.id.edtNickChange;
      EditText edtNickChange = ViewBindings.findChildViewById(rootView, id);
      if (edtNickChange == null) {
        break missingId;
      }

      id = R.id.imgProfileChange;
      CircleImageView imgProfileChange = ViewBindings.findChildViewById(rootView, id);
      if (imgProfileChange == null) {
        break missingId;
      }

      id = R.id.linearLayout;
      LinearLayout linearLayout = ViewBindings.findChildViewById(rootView, id);
      if (linearLayout == null) {
        break missingId;
      }

      id = R.id.linearLayout2;
      LinearLayout linearLayout2 = ViewBindings.findChildViewById(rootView, id);
      if (linearLayout2 == null) {
        break missingId;
      }

      id = R.id.tvProfileNIckhint;
      TextView tvProfileNIckhint = ViewBindings.findChildViewById(rootView, id);
      if (tvProfileNIckhint == null) {
        break missingId;
      }

      id = R.id.tvProfileTitle;
      TextView tvProfileTitle = ViewBindings.findChildViewById(rootView, id);
      if (tvProfileTitle == null) {
        break missingId;
      }

      return new ActivityProfileUpdateBinding((ConstraintLayout) rootView, btnNickChange,
          btnProfileUpdatePre, divider8, edtNickChange, imgProfileChange, linearLayout,
          linearLayout2, tvProfileNIckhint, tvProfileTitle);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
