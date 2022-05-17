// Generated by view binder compiler. Do not edit!
package com.example.umgrade.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.umgrade.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivitySupportWriteBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final Button btnSupportCancel;

  @NonNull
  public final Button btnSupportSend;

  @NonNull
  public final View divider2;

  @NonNull
  public final View divider3;

  @NonNull
  public final EditText edtSupportContent;

  @NonNull
  public final EditText edtSupportTitle;

  @NonNull
  public final Guideline guideline4;

  @NonNull
  public final LinearLayout linearLayout2;

  @NonNull
  public final ScrollView scrollView3;

  @NonNull
  public final TextView tvSupport;

  private ActivitySupportWriteBinding(@NonNull ConstraintLayout rootView,
      @NonNull Button btnSupportCancel, @NonNull Button btnSupportSend, @NonNull View divider2,
      @NonNull View divider3, @NonNull EditText edtSupportContent,
      @NonNull EditText edtSupportTitle, @NonNull Guideline guideline4,
      @NonNull LinearLayout linearLayout2, @NonNull ScrollView scrollView3,
      @NonNull TextView tvSupport) {
    this.rootView = rootView;
    this.btnSupportCancel = btnSupportCancel;
    this.btnSupportSend = btnSupportSend;
    this.divider2 = divider2;
    this.divider3 = divider3;
    this.edtSupportContent = edtSupportContent;
    this.edtSupportTitle = edtSupportTitle;
    this.guideline4 = guideline4;
    this.linearLayout2 = linearLayout2;
    this.scrollView3 = scrollView3;
    this.tvSupport = tvSupport;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivitySupportWriteBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivitySupportWriteBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_support_write, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivitySupportWriteBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btnSupportCancel;
      Button btnSupportCancel = ViewBindings.findChildViewById(rootView, id);
      if (btnSupportCancel == null) {
        break missingId;
      }

      id = R.id.btnSupportSend;
      Button btnSupportSend = ViewBindings.findChildViewById(rootView, id);
      if (btnSupportSend == null) {
        break missingId;
      }

      id = R.id.divider2;
      View divider2 = ViewBindings.findChildViewById(rootView, id);
      if (divider2 == null) {
        break missingId;
      }

      id = R.id.divider3;
      View divider3 = ViewBindings.findChildViewById(rootView, id);
      if (divider3 == null) {
        break missingId;
      }

      id = R.id.edtSupportContent;
      EditText edtSupportContent = ViewBindings.findChildViewById(rootView, id);
      if (edtSupportContent == null) {
        break missingId;
      }

      id = R.id.edtSupportTitle;
      EditText edtSupportTitle = ViewBindings.findChildViewById(rootView, id);
      if (edtSupportTitle == null) {
        break missingId;
      }

      id = R.id.guideline4;
      Guideline guideline4 = ViewBindings.findChildViewById(rootView, id);
      if (guideline4 == null) {
        break missingId;
      }

      id = R.id.linearLayout2;
      LinearLayout linearLayout2 = ViewBindings.findChildViewById(rootView, id);
      if (linearLayout2 == null) {
        break missingId;
      }

      id = R.id.scrollView3;
      ScrollView scrollView3 = ViewBindings.findChildViewById(rootView, id);
      if (scrollView3 == null) {
        break missingId;
      }

      id = R.id.tvSupport;
      TextView tvSupport = ViewBindings.findChildViewById(rootView, id);
      if (tvSupport == null) {
        break missingId;
      }

      return new ActivitySupportWriteBinding((ConstraintLayout) rootView, btnSupportCancel,
          btnSupportSend, divider2, divider3, edtSupportContent, edtSupportTitle, guideline4,
          linearLayout2, scrollView3, tvSupport);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
