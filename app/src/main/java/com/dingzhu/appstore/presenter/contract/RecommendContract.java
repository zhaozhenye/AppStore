package com.dingzhu.appstore.presenter.contract;

import com.dingzhu.appstore.bean.AppInfo;
import com.dingzhu.appstore.ui.BaseView;

import java.util.List;

/**
 * Created by wulimin on 2018/1/25.
 */

public interface RecommendContract {
    interface View extends BaseView {
        void showResult(List<AppInfo> datas);

        void showNodata();

        void showError(String msg);
    }
}
