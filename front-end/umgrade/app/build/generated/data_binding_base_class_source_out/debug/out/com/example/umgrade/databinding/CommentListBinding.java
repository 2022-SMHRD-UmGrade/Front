// Generated by view binder compiler. Do not edit!
package com.example.umgrade.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.example.umgrade.R;
import de.hdodenhof.circleimageview.CircleImageView;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class CommentListBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final ConstraintLayout commentListItem;

  @NonNull
  public final EditText edtCommentContent;

  @NonNull
  public final Guideline guideline6;

  @NonNull
  public final CircleImageView imgCommentProfile;

  @NonNull
  public final TextView tvCommentContent;

  @NonNull
  public final TextView tvCommentDel;

  @NonNull
  public final TextView tvCommentModify;

  @NonNull
  public final TextView tvCommentNick;

  @NonNull
  public final TextView tvCommentReport;

  @NonNull
  public final TextView tvCommentSuccess;

  @NonNull
  public final TextView tvCommentTime;

  @NonNull
  public final TextView tvPostSeq;

  @NonNull
  public final TextView tvSeq;

  @NonNull
  public final TextView tvWriter;

  private CommentListBinding(@NonNull ConstraintLayout rootView,
      @NonNull ConstraintLayout commentListItem, @NonNull EditText edtCommentContent,
      @NonNull Guideline guideline6, @NonNull CircleImageView imgCommentProfile,
      @NonNull TextView tvCommentContent, @NonNull TextView tvCommentDel,
      @NonNull TextView tvCommentModify, @NonNull TextView tvCommentNick,
      @NonNull TextView tvCommentReport, @NonNull TextView tvCommentSuccess,
      @NonNull TextView tvCommentTime, @NonNull TextView tvPostSeq, @NonNull TextView tvSeq,
      @NonNull TextView tvWriter) {
    this.rootView = rootView;
    this.commentListItem = commentListItem;
    this.edtCommentContent = edtCommentContent;
    this.guideline6 = guideline6;
    this.imgCommentProfile = imgCommentProfile;
    this.tvCommentContent = tvCommentContent;
    this.tvCommentDel = tvCommentDel;
    this.tvCommentModify = tvCommentModify;
    this.tvCommentNick = tvCommentNick;
    this.tvCommentReport = tvCommentReport;
    this.tvCommentSuccess = tvCommentSuccess;
    this.tvCommentTime = tvCommentTime;
    this.tvPostSeq = tvPostSeq;
    this.tvSeq = tvSeq;
    this.tvWriter = tvWriter;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static CommentListBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static CommentListBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.comment_list, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static CommentListBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      ConstraintLayout commentListItem = (ConstraintLayout) rootView;

      id = R.id.edtCommentContent;
      EditText edtCommentContent = ViewBindings.findChildViewById(rootView, id);
      if (edtCommentContent == null) {
        break missingId;
      }

      id = R.id.guideline6;
      Guideline guideline6 = ViewBindings.findChildViewById(rootView, id);
      if (guideline6 == null) {
        break missingId;
      }

      id = R.id.imgCommentProfile;
      CircleImageView imgCommentProfile = ViewBindings.findChildViewById(rootView, id);
      if (imgCommentProfile == null) {
        break missingId;
      }

      id = R.id.tvCommentContent;
      TextView tvCommentContent = ViewBindings.findChildViewById(rootView, id);
      if (tvCommentContent == null) {
        break missingId;
      }

      id = R.id.tvCommentDel;
      TextView tvCommentDel = ViewBindings.findChildViewById(rootView, id);
      if (tvCommentDel == null) {
        break missingId;
      }

      id = R.id.tvCommentModify;
      TextView tvCommentModify = ViewBindings.findChildViewById(rootView, id);
      if (tvCommentModify == null) {
        break missingId;
      }

      id = R.id.tvCommentNick;
      TextView tvCommentNick = ViewBindings.findChildViewById(rootView, id);
      if (tvCommentNick == null) {
        break missingId;
      }

      id = R.id.tvCommentReport;
      TextView tvCommentReport = ViewBindings.findChildViewById(rootView, id);
      if (tvCommentReport == null) {
        break missingId;
      }

      id = R.id.tvCommentSuccess;
      TextView tvCommentSuccess = ViewBindings.findChildViewById(rootView, id);
      if (tvCommentSuccess == null) {
        break missingId;
      }

      id = R.id.tvCommentTime;
      TextView tvCommentTime = ViewBindings.findChildViewById(rootView, id);
      if (tvCommentTime == null) {
        break missingId;
      }

      id = R.id.tvPostSeq;
      TextView tvPostSeq = ViewBindings.findChildViewById(rootView, id);
      if (tvPostSeq == null) {
        break missingId;
      }

      id = R.id.tvSeq;
      TextView tvSeq = ViewBindings.findChildViewById(rootView, id);
      if (tvSeq == null) {
        break missingId;
      }

      id = R.id.tvWriter;
      TextView tvWriter = ViewBindings.findChildViewById(rootView, id);
      if (tvWriter == null) {
        break missingId;
      }

      return new CommentListBinding((ConstraintLayout) rootView, commentListItem, edtCommentContent,
          guideline6, imgCommentProfile, tvCommentContent, tvCommentDel, tvCommentModify,
          tvCommentNick, tvCommentReport, tvCommentSuccess, tvCommentTime, tvPostSeq, tvSeq,
          tvWriter);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
