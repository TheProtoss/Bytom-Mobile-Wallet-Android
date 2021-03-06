package bytom.io.my.transaction.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

import bytom.io.R;
import bytom.io.entity.transaction.TransListGroupEntity;
import bytom.io.entity.transaction.TransListItemEntity;
import bytom.io.my.transaction.activity.TransactionDetailActivity;

/**
 * <b>版权</b>：　　　比原链 版权所有(c) 2018 <br>
 * <b>作者</b>：　　　愤世嫉俗
 * <b>创建日期</b>：　18/6/12 <br>
 */


public class TransactionListAdapter extends BaseExpandableListAdapter {

    private Context mContext;
    private ArrayList<TransListGroupEntity> mGroupList;
    private ArrayList<ArrayList<TransListItemEntity>> mChildGroupList;

    public TransactionListAdapter(Context context, ArrayList<TransListGroupEntity> groupList,
                                  ArrayList<ArrayList<TransListItemEntity>> childList) {
        mContext = context;
        mGroupList = groupList;
        mChildGroupList = childList;
    }

    @Override
    public int getGroupCount() {
        if(null != mGroupList)
            return mGroupList.size();
        return 0;
    }

    @Override
    public int getChildrenCount(int i) {
        if(null != mChildGroupList)
            return mChildGroupList.get(i).size();
        return 0;
    }

    @Override
    public Object getGroup(int i) {
        if(null != mGroupList)
            mGroupList.get(i);
        return null;
    }

    @Override
    public Object getChild(int i, int i1) {
        if(null != mChildGroupList)
            return mChildGroupList.get(i).get(i1);
        return null;
    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int i, int i1) {
        return i1;
    }

    @Override
    public View getGroupView(int i, boolean b, View convertView, ViewGroup viewGroup) {
        ViewHolderGroup groupHolder;
        if(null == convertView) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_trans_group, null);
            groupHolder = new ViewHolderGroup();
            groupHolder.textView = (TextView) convertView.findViewById(R.id.tv_time);
            groupHolder.imageView = (ImageView) convertView.findViewById(R.id.iv_arrow);
            groupHolder.lineView = (TextView) convertView.findViewById(R.id.tv_line);
            convertView.setTag(groupHolder);
        } else {
            groupHolder = (ViewHolderGroup)convertView.getTag();
        }
        if(null != mGroupList.get(i))
            groupHolder.textView.setText(mGroupList.get(i).getTime());

        if (b) {
            groupHolder.imageView.setImageResource(R.mipmap.arrow_open);
            groupHolder.lineView.setVisibility(View.GONE);
        } else {
            groupHolder.imageView.setImageResource(R.mipmap.arrow_right);
            groupHolder.lineView.setVisibility(View.VISIBLE);
        }

        return convertView;
    }

    @Override
    public View getChildView(int i, int i1, boolean b, View convertView, ViewGroup viewGroup) {
        ViewHolderChild childHolder;
        if(null == convertView) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_trans_child, null);
            childHolder = new ViewHolderChild();
            childHolder.childLayout = (RelativeLayout) convertView.findViewById(R.id.rl_layout);
            childHolder.addrview = (TextView) convertView.findViewById(R.id.tv_addr);
            childHolder.classifyView = (TextView) convertView.findViewById(R.id.tv_num);
            childHolder.timeView = (TextView) convertView.findViewById(R.id.tv_time);
            childHolder.statusView = (TextView) convertView.findViewById(R.id.tv_status);
            convertView.setTag(childHolder);
        } else {
            childHolder = (ViewHolderChild)convertView.getTag();
        }
        if(null != mChildGroupList.get(i)) {
            childHolder.addrview.setText(mChildGroupList.get(i).get(i).getAddr());
            childHolder.classifyView.setText(mChildGroupList.get(i).get(i).getClassify());
            childHolder.timeView.setText(mChildGroupList.get(i).get(i).getTime());
            childHolder.statusView.setText(mChildGroupList.get(i).get(i).getNum());
            childHolder.childLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(mContext, TransactionDetailActivity.class);
                    mContext.startActivity(intent);
                }
            });
        }

        return convertView;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    class ViewHolderGroup{
        private TextView textView;
        private ImageView imageView;
        private TextView lineView;
    }

    class ViewHolderChild{
        private RelativeLayout childLayout;
        private ImageView iconView;
        private TextView addrview;
        private TextView classifyView;
        private TextView timeView;
        private TextView statusView;
    }
}
