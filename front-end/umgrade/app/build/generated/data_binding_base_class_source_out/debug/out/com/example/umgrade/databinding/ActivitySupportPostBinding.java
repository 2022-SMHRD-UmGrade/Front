// Generated by view binder compiler. Do not edit!
package com.example.umgrade.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
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

public final class ActivitySupportPostBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final Button btnSupportComment;

  @NonNull
  public final Button btnSupportDelete;

  @NonNull
  public final ConstraintLayout constraintLayout;

  @NonNull
  public final ConstraintLayout constraintLayout3;

  @NonNull
  public final View divSupportPost1;

  @NonNull
  public final View divSupportPost2;

  @NonNull
  public final View divider16;

  @NonNull
  public final View divider17;

  @NonNull
  public final EditText edtSupportComment;

  @NonNull
  public final ScrollView scrollView4;

  @NonNull
  public final TextView supportPostCnt;

  @NonNull
  public final TextView supportPostContent;

  @NonNull
  public final TextView supportPostSeq;

  @NonNull
  public final TextView supportPostTime;

  @NonNull
  public final TextView supportPostTitle;

  @NonNull
  public final TextView tvSupportPostComment;

  @NonNull
  public final TextView tvSupportSet;

  private ActivitySupportPostBinding(@NonNull ConstraintLayout rootView,
      @NonNull Button btnSupportComment, @NonNull Button btnSupportDelete,
      @NonNull ConstraintLayout constraintLayout, @NonNull ConstraintLayout constraintLayout3,
      @NonNull View divSupportPost1, @NonNull View divSupportPost2, @NonNull View divider16,
      @NonNull View divider17, @NonNull EditText edtSupportComment, @NonNull ScrollView scrollView4,
      @NonNull TextView supportPostCnt, @NonNull TextView supportPostContent,
      @NonNull TextView supportPostSeq, @NonNull TextView supportPostTime,
      @NonNull TextView supportPostTitle, @NonNull TextView tvSupportPostComment,
      @NonNull TextView tvSupportSet) {
    this.rootView = rootView;
    this.btnSupportComment = btnSupportComment;
    this.btnSupportDelete = btnSupportDelete;
    this.constraintLayout = constraintLayout;
    this.constraintLayout3 = constraintLayout3;
    this.divSupportPost1 = divSupportPost1;
    this.divSupportPost2 = divSupportPost2;
    this.divider16 = divider16;
    this.divider17 = divider17;
    this.edtSupportComment = edtSupportComment;
    this.scrollView4 = scrollView4;
    this.supportPostCnt = supportPostCnt;
    this.supportPostContent = supportPostContent;
    this.supportPostSeq = supportPostSeq;
    this.supportPostTime = supportPostTime;
    this.supportPostTitle = supportPostTitle;
    this.tvSupportPostComment = tvSupportPostComment;
    this.tvSupportSet = tvSupportSet;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static ActivitySupportPostBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static ActivitySupportPostBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.activity_support_post, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static ActivitySupportPostBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.btnSupportComment;
      Button btnSupportComment = ViewBindings.findChildViewById(rootView, id);
      if (btnSupportComment == null) {
        break missingId;
      }

      id = R.id.btnSupportDelete;
      Button btnSupportDelete = ViewBindings.findChildViewById(rootView, id);
      if (btnSupportDelete == null) {
        break missingId;
      }

      id = R.id.constraintLayout;
      ConstraintLayout constraintLayout = ViewBindings.findChildViewById(rootView, id);
      if (constraintLayout == null) {
        break missingId;
      }

      id = R.id.constraintLayout3;
      ConstraintLayout constraintLayout3 = ViewBindings.findChildViewById(rootView, id);
      if (constraintLayout3 == null) {
        break missingId;
      }

      id = R.id.divSupportPost1;
      View divSupportPost1 = ViewBindings.findChildViewById(rootView, id);
      if (divSupportPost1 == null) {
        break missingId;
      }

      id = R.id.divSupportPost2;
      View divSupportPost2 = ViewBindings.findChildViewById(rootView, id);
      if (divSupportPost2 == null) {
        break missingId;
      }

      id = R.id.divider16;
      View divider16 = ViewBindings.findChildViewById(rootView, id);
      if (divider16 == null) {
        break missingId;
      }

      id = R.id.divider17;
      View divider17 = ViewBindings.findChildViewById(rootView, id);
      if (divider17 == null) {
        break missingId;
      }

      id = R.id.edtSupportComment;
      EditText edtSupportComment = ViewBindings.findChildViewById(rootView, id);
      if (edtSupportComment == null) {
        break missingId;
      }

      id = R.id.scrollView4;
      ScrollView scrollView4 = ViewBindings.findChildViewById(rootView, id);
      if (scrollView4 == null) {
        break missingId;
      }

      id = R.id.supportPostCnt;
      TextView supportPostCnt = ViewBindings.findChildViewById(rootView, id);
      if (supportPostCnt == null) {
        break missingId;
      }

      id = R.id.supportPostContent;
      TextView supportPostContent = ViewBindings.findChildViewById(rootView, id);
      if (supportPostContent == null) {
        break missingId;
      }

      id = R.id.supportPostSeq;
      TextView supportPostSeq = ViewBindings.findChildViewById(rootView, id);
      if (supportPostSeq == null) {
        break missingId;
      }

      id = R.id.supportPostTime;
      TextView supportPostTime = ViewBindings.findChildViewById(rootView, id);
      if (supportPostTime == null) {
        break missingId;
      }

      id = R.id.supportPostTitle;
      TextView supportPostTitle = ViewBindings.findChildViewById(rootView, id);
      if (supportPostTitle == null) {
        break missingId;
      }

      id = R.id.tvSupportPostComment;
      TextView tvSupportPostComment = ViewBindings.findChildViewById(rootView, id);
      if (tvSupportPostComment == null) {
        break missingId;
      }

      id = R.id.tvSupportSet;
      TextView tvSupportSet = ViewBindings.findChildViewById(rootView, id);
      if (tvSupportSet == null) {
        break missingId;
      }

      return new ActivitySupportPostBinding((ConstraintLayout) rootView, btnSupportComment,
          btnSupportDelete, constraintLayout, constraintLayout3, divSupportPost1, divSupportPost2,
          divider16, divider17, edtSupportComment, scrollView4, supportPostCnt, supportPostContent,
          supportPostSeq, supportPostTime, supportPostTitle, tvSupportPostComment, tvSupportSet);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
