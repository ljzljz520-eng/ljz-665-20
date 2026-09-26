import { resultSuccess, resultError, getRequestToken, requestParams, baseUrl } from '../_util';
import { MockMethod } from 'vite-plugin-mock';
import { createFakeUserList } from './user';
import { PageEnum } from '/@/enums/pageEnum';

// 首页工作台菜单
const dashboardRoute = {
  path: '/dashboard',
  name: 'Dashboard',
  component: 'LAYOUT',
  redirect: PageEnum.BASE_HOME,
  meta: {
    title: 'routes.dashboard.dashboard',
    hideChildrenInMenu: true,
    icon: 'bx:bx-home',
  },
  children: [
    {
      path: 'analysis',
      name: 'Analysis',
      component: '/dashboard/Analysis/index',
      meta: {
        hideMenu: true,
        hideBreadcrumb: true,
        title: 'routes.dashboard.analysis',
        currentActiveMenu: '/dashboard',
        icon: 'bx:bx-home',
      },
    },
    {
      path: 'workbench',
      name: 'Workbench',
      component: '/dashboard/workbench/index',
      meta: {
        hideMenu: true,
        hideBreadcrumb: true,
        title: 'routes.dashboard.workbench',
        currentActiveMenu: '/dashboard',
        icon: 'bx:bx-home',
      },
    },
  ],
};

export default [
  {
    url: `${baseUrl}/sys/permission/getUserPermissionByToken`,
    timeout: 1000,
    method: 'get',
    response: (request: requestParams) => {
      const token = getRequestToken(request);
      if (!token) {
        return resultError('Invalid token!');
      }
      const checkUser = createFakeUserList().find((item) => item.token === token);
      if (!checkUser) {
        return resultError('Invalid user token!');
      }
      const id = checkUser.userId;
      let menu: Object[];
      switch (id) {
        case '1':
          dashboardRoute.redirect = dashboardRoute.path + '/' + dashboardRoute.children[0].path;
          menu = [dashboardRoute];
          break;
        case '2':
          dashboardRoute.redirect = dashboardRoute.path + '/' + dashboardRoute.children[1].path;
          menu = [dashboardRoute];
          break;
        default:
          menu = [];
      }

      return resultSuccess(menu);
    },
  },
] as MockMethod[];
