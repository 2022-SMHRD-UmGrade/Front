// Generated by view binder compiler. Do not edit!
package com.example.umgrade.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.umgrade.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class ActivityCommentBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final Button btnComment;

  @NonNull
  public final ConstraintLayout constraintLayout8;

  @NonNull
  public final View divider5;

  @NonNull
  public final EditText edtComment;

  @NonNull
  public final Guideline guideline5;

  @NonNull
  public final RecyclerView rvComment;

  private ActivityCommentBinding(@NonNull ConstraintLayout rootView, @NonNull Button btnComment,
      @NonNull ConstraintLayout constraintLayout8, @NonNull View divider5,
      @NonNull EditText edtComment, @NonNull Guideline guideline5,
      @NonNull RecyclerView rvComment) {
    this.rootView = rootView;
    this.btnComment = btnComment;
    this.constraintLayout8 = constraintLayout8;
    this.divider5 = divider5;
    this.edtComment = edtComment;
    this.guideline5 = guideline5;
    this.rvComment = rvComment;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivityCommentBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivityCommentBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_comment, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivityCommentBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btnComment;
      Button btnComment = ViewBindings.findChildViewById(rootView, id);
      if (btnComment == null) {
        break missingId;
      }

      id = R.id.constraintLayout8;
      ConstraintLayout constraintLayout8 = ViewBindings.findChildViewById(rootView, id);
      if (constraintLayout8 == null) {
        break missingId;
      }

      id = R.id.divider5;
      View divider5 = ViewBindings.findChildViewById(rootView, id);
      if (divider5 == null) {
        break missingId;
      }

      id = R.id.edtComment;
      EditText edtComment = ViewBindings.findChildViewById(rootView, id);
      if (edtComment == null) {
        break missingId;
      }

      id = R.id.guideline5;
      Guideline guideline5 = ViewBindings.findChildViewById(rootView, id);
      if (guideline5 == null) {
        break missingId;
      }

      id = R.id.rvComment;
      RecyclerView rvComment = ViewBindings.findChildViewById(rootView, id);
      if (rvComment == null) {
        break missingId;
      }

      return new ActivityCommentBinding((ConstraintLayout) rootView, btnComment, constraintLayout8,
          divider5, edtComment, guideline5, rvComment);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
