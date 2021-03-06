// Generated by view binder compiler. Do not edit!
package com.example.umgrade.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.umgrade.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class SupportListBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final ConstraintLayout supportListItem;

  @NonNull
  public final TextView supportSeq;

  @NonNull
  public final TextView supportTime;

  @NonNull
  public final TextView supportTitle;

  @NonNull
  public final TextView tvSet;

  private SupportListBinding(@NonNull ConstraintLayout rootView,
      @NonNull ConstraintLayout supportListItem, @NonNull TextView supportSeq,
      @NonNull TextView supportTime, @NonNull TextView supportTitle, @NonNull TextView tvSet) {
    this.rootView = rootView;
    this.supportListItem = supportListItem;
    this.supportSeq = supportSeq;
    this.supportTime = supportTime;
    this.supportTitle = supportTitle;
    this.tvSet = tvSet;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static SupportListBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static SupportListBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.support_list, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static SupportListBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      ConstraintLayout supportListItem = (ConstraintLayout) rootView;

      id = R.id.supportSeq;
      TextView supportSeq = ViewBindings.findChildViewById(rootView, id);
      if (supportSeq == null) {
        break missingId;
      }

      id = R.id.supportTime;
      TextView supportTime = ViewBindings.findChildViewById(rootView, id);
      if (supportTime == null) {
        break missingId;
      }

      id = R.id.supportTitle;
      TextView supportTitle = ViewBindings.findChildViewById(rootView, id);
      if (supportTitle == null) {
        break missingId;
      }

      id = R.id.tvSet;
      TextView tvSet = ViewBindings.findChildViewById(rootView, id);
      if (tvSet == null) {
        break missingId;
      }

      return new SupportListBinding((ConstraintLayout) rootView, supportListItem, supportSeq,
          supportTime, supportTitle, tvSet);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
