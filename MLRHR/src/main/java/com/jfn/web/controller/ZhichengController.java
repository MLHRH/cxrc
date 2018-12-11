package com.jfn.web.controller;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springside.modules.security.springsecurity.SpringSecurityUtils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.JsonObject;
import com.jfn.common.util.BasePDFWrite;
import com.jfn.common.util.FileUtil;
import com.jfn.entity.AcctUserRole;
import com.jfn.entity.ApplyGroup;
import com.jfn.entity.ApplyMenu;
import com.jfn.entity.Attachfile;
import com.jfn.entity.CxtdBaseInfo;
import com.jfn.entity.CxtdDoc03;
import com.jfn.entity.CxtdDoc04;
import com.jfn.entity.CxtdDoc05;
import com.jfn.entity.CxtdLeaderInfo;
import com.jfn.entity.CxtdMemberInfo;
import com.jfn.entity.CxtdMemberNum;
import com.jfn.entity.ExpertScore;
import com.jfn.entity.ExpertUser;
import com.jfn.entity.ExpertVote;
import com.jfn.entity.Group;
import com.jfn.entity.JcqnDoc01;
import com.jfn.entity.JcqnDoc03;
import com.jfn.entity.JcqnDoc04;
import com.jfn.entity.JcqnDoc05;
import com.jfn.entity.JcqnDocPatent;
import com.jfn.entity.JcqnDocPrize;
import com.jfn.entity.JcqnDocProject;
import com.jfn.entity.JcqnDocReport;
import com.jfn.entity.JcqnDocThesis;
import com.jfn.entity.JcqnDocTreatise;
import com.jfn.entity.KjljDoc01;
import com.jfn.entity.KjljDoc03;
import com.jfn.entity.KjljDoc04;
import com.jfn.entity.KjljDoc05;
import com.jfn.entity.Role;
import com.jfn.entity.UesrZuzhi;
import com.jfn.entity.User;
import com.jfn.entity.UserPeixun;
import com.jfn.entity.UserWork;
import com.jfn.entity.ZhichengApply;
import com.jfn.service.AccountManager;
import com.jfn.service.ApplyMenuService;
import com.jfn.service.BodyService;
import com.jfn.service.CalendarService;
import com.jfn.service.ExpertUserService;
import com.jfn.service.GroupService;
import com.jfn.service.JcqnDocService;
import com.jfn.service.KjljDocService;
import com.jfn.service.UserAwardService;
import com.jfn.service.UserBaogaoService;
import com.jfn.service.UserChengguoService;
import com.jfn.service.UserPeixunService;
import com.jfn.service.UserProjectService;
import com.jfn.service.UserReportService;
import com.jfn.service.UserService;
import com.jfn.service.UserWorkService;
import com.jfn.service.UserZhuanliService;
import com.jfn.service.UserZuzhiService;
import com.jfn.service.ZhichengApplyService;
import com.jfn.service.cxtdDocService;

@Controller
@RequestMapping("/")
public class ZhichengController {
	@Autowired
	private cxtdDocService cxtdDocService;
	@Autowired
	private KjljDocService kjljDocService;
	@Autowired
	private JcqnDocService jcqndoc01servive;
	@Autowired
	private UserPeixunService ups;
	@Autowired
	private UserWorkService uws;
	@Autowired
	private UserZuzhiService userZuzhiService;
	@Autowired
	private ZhichengApplyService zervice;

	@Autowired
	private ApplyMenuService applyMenuService;

	@Autowired
	private UserChengguoService cgservice;

	@Autowired
	private UserBaogaoService eservice;

	@Autowired
	private UserReportService rservice;
	
	@Autowired
	private UserAwardService userAwardService;

	@Autowired
	private UserProjectService pservice;

	@Autowired
	private UserZhuanliService wservice;
	@Autowired
	private AccountManager accountManager;
	@Autowired
	private UserService uservice;
	@Autowired
	private UserService userservice;
	@Autowired
	private BodyService bodyservice;
	@Autowired
	private ZhichengApplyService zhichengapplyservice;
	@Autowired
	private CalendarService calendarservice;
	@Autowired
	private GroupService groupService;
	@Autowired
	private ExpertUserService expertUserService;

	/**
	 * 申请编辑
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "zhichengApplyEdit", method = RequestMethod.GET)
	public ModelAndView zhichengApplyEdit(HttpServletRequest request, Model model) {
		String applyid = request.getParameter("applyid");
		// 根据id查询申请类型
		ZhichengApply apply = zhichengapplyservice.getById(applyid);
		// 根据申请类型查询对应菜单
		List<ApplyMenu> menus = applyMenuService.getMenu(apply.getApply_type());

		ModelAndView map = new ModelAndView("zhicheng/zhichengApply");
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("loginuser");
		ExpertUser expertUser = expertUserService.getByUserId(user.getId());
		AcctUserRole acctUserRole = zhichengapplyservice.getRoleByUserId(user.getId());
		List<ApplyMenu> menus2 = new ArrayList<ApplyMenu>();
		menus2.add(menus.get(0));
		menus2.add(menus.get(1));
		menus2.add(menus.get(2));
		menus2.add(menus.get(3));
		menus2.add(menus.get(4));
		menus2.add(menus.get(5));
		menus2.add(menus.get(7));
		if (acctUserRole.getRole_id() == 4) {
			menus2.add(menus.get(6));
		} 
		if (acctUserRole.getRole_id() == 3 || acctUserRole.getRole_id() == 6) {
			menus2.add(menus.get(8));
			menus2.add(menus.get(9));
		}
		int status = Integer.valueOf(apply.getStatus());
		if (status < 4) {
			if (expertUser.getTeam_leader_type() != null
					&& (expertUser.getTeam_leader_type() == 1 || expertUser.getTeam_leader_type() == 2)) {
				menus2.add(menus.get(9));
			}
		}
		if (status > 3) {
			if (expertUser.getTeam_leader_type() != null
					&& (expertUser.getTeam_leader_type() == 1 || expertUser.getTeam_leader_type() == 2)) {
				menus2.add(menus.get(9));
			}
		}
		map.addObject("menus", menus2);
		map.addObject("type", menus.get(0).getMenutype());
		map.addObject("applyid", applyid);
		map.addObject("apply_userid", apply.getUser_id());
		return map;
	}

	/**
	 * 添加申请
	 * 
	 * @param request
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "zhichengApply", method = RequestMethod.GET)
	public ModelAndView zhichengApply(HttpServletRequest request, Model model) {
		String applyType = request.getParameter("apply_type");
		if (applyType == null) {
			applyType = "杰出青年";
		}
		// 根据申请类型查询对应菜单
		List<ApplyMenu> menus = applyMenuService.getMenu(applyType);

		ModelAndView map = new ModelAndView("zhicheng/zhichengApply");
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("loginuser");
		// AcctUserRole acctUserRole
		// =zhichengapplyservice.getRoleByUserId(user.getId());

		List<ApplyMenu> menus2 = new ArrayList<ApplyMenu>();
		menus2.add(menus.get(10));
		menus2.add(menus.get(0));
		menus2.add(menus.get(1));
		menus2.add(menus.get(2));
		menus2.add(menus.get(3));
		menus2.add(menus.get(4));
		menus2.add(menus.get(5));
		menus2.add(menus.get(7));
		map.addObject("menus", menus2);

		map.addObject("type", applyType);
		map.addObject("apply_userid", user.getId());
		return map;
	}

	@RequestMapping(value = "zhichengApplylist", method = RequestMethod.GET)
	public String zhichengApplylist(HttpServletRequest request, Model model) {
		return "zhicheng/zhichengApplylist";
	}

	@RequestMapping(value = "expertzhichengApplylist", method = RequestMethod.GET)
	public String expertZhichengApplylist(HttpServletRequest request, Model model) {
		return "zhicheng/expertzhichengApplylist";
	}

	/**
	 * 得到申报材料的列表名称
	 * 
	 * @param applytype
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "applyMenu", method = RequestMethod.GET)
	public ModelAndView ApplyMenu(HttpServletRequest request, String applytype) {
		String type = null;
		try {
			type = new String(applytype.getBytes("ISO8859-1"), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		if (type != null && type.length() > 4) {
			type = type.substring(1, 5);
		}
		List<ApplyMenu> menus = null;
		if (!applytype.equals("杰出青年") && !applytype.equals("科技领军") && !applytype.equals("创新团队")) {
			 menus = applyMenuService.getMenu(type);			
		}else {
			menus = applyMenuService.getMenu(applytype);
		}
		ModelAndView map = new ModelAndView("zhicheng/zhichengApply");
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("loginuser");
		AcctUserRole acctUserRole = zhichengapplyservice.getRoleByUserId(user.getId());
		if (acctUserRole.getRole_id() != 4 && acctUserRole.getRole_id() != 5) {
			List<ApplyMenu> menus2 = new ArrayList<ApplyMenu>();
			menus2.add(menus.get(10));
			menus2.add(menus.get(0));
			menus2.add(menus.get(1));
			menus2.add(menus.get(2));
			menus2.add(menus.get(3));
			menus2.add(menus.get(4));
			menus2.add(menus.get(5));
			menus2.add(menus.get(7));
			map.addObject("menus", menus2);
		} else {
			map.addObject("menus", menus);
		}
		map.addObject("type", menus.get(0).getMenutype());
		return map;
	}

	@RequestMapping(value = "zhichengApplylistInit", method = RequestMethod.GET)
	@ResponseBody
	public String zhichengApplylistInit(HttpServletRequest request, Model model) {
		String userId = request.getParameter("userId");
		List<ZhichengApply> list = zhichengapplyservice.getAllByUserId(Integer.parseInt(userId));

		String authority = "";
		SecurityContextImpl securityContextImpl = (SecurityContextImpl) request.getSession()
				.getAttribute("SPRING_SECURITY_CONTEXT");
		@SuppressWarnings("unchecked")
		List<GrantedAuthority> authorities = (List<GrantedAuthority>) securityContextImpl.getAuthentication()
				.getAuthorities();
		for (GrantedAuthority grantedAuthority : authorities) {
			authority = authority + grantedAuthority.getAuthority() + "|";
		}
		JSONObject jo3 = new JSONObject();
		jo3.put("authority", authority);

		com.jfn.entity.Calendar calendar = calendarservice.getById("1");
		String starDate = calendar.getStart_date();
		String endDate = calendar.getEnd_date();
		if (list.size() > 0) {
			for (int i = 0; i < list.size(); i++) {
				Group group = groupService.getGroupTreeById(Integer.valueOf(list.get(i).getGroup_id()));
				list.get(i).setGroup_id(group.getName());
			}

			ZhichengApply zhichengapply = list.get(0);
			if (zhichengapply.getApply_date().compareTo(starDate) > 0
					&& zhichengapply.getApply_date().compareTo(endDate) > 0) {
				jo3.put("hasOne", "1");
			} else {
				jo3.put("hasOne", "0");
			}
		} else {
			jo3.put("hasOne", "0");
		}
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("loginuser");
		JSONArray jsonArray = new JSONArray();
		jsonArray.add(list);
		jsonArray.add(jo3);
		jsonArray.add(user);
		return jsonArray.toString();
	}

	@RequestMapping(value = "zhichengManage", method = RequestMethod.GET)
	public String zhichengManage(HttpServletRequest request, Model model) {
		User user = accountManager.findUserByLoginName(SpringSecurityUtils.getCurrentUserName());

		List<Role> myrole = accountManager.getUserRole(user.getId());
		Set<ZhichengApply> ZhichengApplySet = new LinkedHashSet<ZhichengApply>();
		for (Role roleobj : myrole) {
			if (roleobj.getName().equals("DepartHR")) {
				List<User> userlist = uservice.getAllByBodyId(user.getBody_id());
				for (User userobj : userlist) {
					List<ZhichengApply> UserZhichengApplylist = zervice.getAllByUserId(userobj.getId());
					for (ZhichengApply ZhichengApplyobj : UserZhichengApplylist) {
						ZhichengApplySet.add((ZhichengApplyobj));
					}
				}
				model.addAttribute("zhichengApplyList", ZhichengApplySet);
			} else if (roleobj.getName().equals("HR")) {
				ZhichengApplySet.clear();
				List<User> userlist = uservice.getAll();
				for (User userobj : userlist) {
					List<ZhichengApply> UserZhichengApplylist = zervice.getAllByUserId(userobj.getId());
					for (ZhichengApply ZhichengApplyobj : UserZhichengApplylist) {
						ZhichengApplySet.add((ZhichengApplyobj));
					}
				}
				model.addAttribute("zhichengApplyList", ZhichengApplySet);
			}
		}
		return "zhicheng/zhichengApplymanage";
	}

	// 职称提交(增加、修改)
	@RequestMapping(value = "/zhichengApplyUpdate", method = RequestMethod.POST)
	@ResponseBody
	public String zhichengApplyUpdate(HttpServletRequest request, @ModelAttribute ZhichengApply entity) {
		JsonObject jsonResponse = new JsonObject();
		int result = 0;// 0:fail;1:success
		String msg = "Failed to %s this zhicheng";
		String id = request.getParameter("id");
		try {
			if ((id == null) || (id.length() < 1)) {
				entity.setGroup_id("1");
				result = zhichengapplyservice.Insert(entity) ? 1 : 0;
			} else {
				System.err.println(JSON.toJSON(entity));
				result = zhichengapplyservice.Update(entity) ? 1 : 0;
			}
		} catch (Exception e) {
			result = 0;
			msg = msg + ": " + e.getMessage();
			System.err.println(e);
		}
		jsonResponse.addProperty("result", result);
		jsonResponse.addProperty("msg", String.format(msg, (id == null) ? "add" : "edit"));
		return jsonResponse.toString();
	}

	// 获取投票信息
	@RequestMapping(value = "/zhichengApplyInteVote", method = RequestMethod.POST)
	@ResponseBody
	public ExpertVote zhichengApplyInteVote(HttpServletRequest request) {
		// String userId = request.getParameter("user_id");
		String expertId = request.getParameter("expert_id");
		String apply_id = request.getParameter("apply_id");
		ExpertVote expertvote = zhichengapplyservice.getByExpertId(Integer.parseInt(expertId),
				Integer.parseInt(apply_id));
		return expertvote;
	}

	// 投票提交(增加、修改)
	@RequestMapping(value = "/zhichengApplyUpdateVote", method = RequestMethod.POST)
	@ResponseBody
	public String zhichengApplyUpdateVote(HttpServletRequest request, @ModelAttribute ExpertVote entity) {
		JsonObject jsonResponse = new JsonObject();
		int result = 0;// 0:fail;1:success
		String msg = "Failed to %s this zhicheng";
		String expert_id = request.getParameter("expert_id");
		String apply_id = request.getParameter("apply_id");
		try {
			System.err.println(zhichengapplyservice
					.getByExpertId(Integer.parseInt(expert_id), Integer.parseInt(apply_id)).getExpert_vote());
			if (zhichengapplyservice.getByExpertId(Integer.parseInt(expert_id), Integer.parseInt(apply_id))
					.getExpert_vote() != null) {
				result = zhichengapplyservice.updateVote(entity) ? 1 : 0;
			} else {
				result = zhichengapplyservice.insertVote(entity) ? 1 : 0;
			}
		} catch (Exception e) {
			result = 0;
			msg = msg + ": " + e.getMessage();
			System.err.println(e);
		}
		jsonResponse.addProperty("result", result);
		// jsonResponse.addProperty("msg", String.format(msg, (expert_id ==
		// null) ? "add" : "edit"));
		return jsonResponse.toString();
	}
	
	// 导出文档
		@RequestMapping(value = "/zhichengApplyExport", method = RequestMethod.GET)
		@ResponseBody
		public void zhichengApplyExport(HttpServletRequest request,HttpServletResponse response, @ModelAttribute ExpertVote entity) throws Exception {
			String userId = request.getParameter("user_id");
			String applytype = request.getParameter("apply_type");
			if (!applytype.equals("杰出青年") && !applytype.equals("科技领军") && !applytype.equals("创新团队")) {
				try {
					applytype = new String(applytype.getBytes("ISO8859-1"), "UTF-8");
				} catch (UnsupportedEncodingException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}		
			}
//			学校经历
			List<UserPeixun> userPeixuns=ups.getAllByUserId(userId);
//	    	工作经历
			List<UserWork> work = uws.getAllByUserId(userId);
//          组织任期情况
			List<UesrZuzhi> uesrZuzhis = userZuzhiService.getAllByUser(userId);
//			承担主要科研任务情况
			List<JcqnDocProject> jcqnDocProjects = pservice.getAllByUserId(userId);
//			获得主要科研学术奖励情况
			List<JcqnDocPrize> jcqnDocPrizes = userAwardService.getAllByUserId(userId);
//			代表性论文
			List<JcqnDocThesis> jcqnDocThesis = cgservice.getAllByUserId(userId);
//			获得授权专利情况
			List<JcqnDocPatent> jcqnDocPatents = wservice.getAllByUserId(userId);
//			在重要国际学术会议报告情况
			List<JcqnDocReport> jcqnDocReports = eservice.getAllByUserId(userId);
//			重要专著情况（不超过5项）
			List<JcqnDocTreatise> jcqnDocTreatises = rservice.getAllByUserId(userId);
			JSONObject result = new JSONObject();
			String path = request.getSession().getServletContext().getRealPath("/")+"fileUpload/";
			if(applytype.equals("杰出青年")){
//				基本信息
				JcqnDoc01 jcqn = jcqndoc01servive.getByUserId01(Integer.parseInt(userId));
//			            推荐人选自我评价
				JcqnDoc03 jcqn03 = jcqndoc01servive.getByUserId03(Integer.parseInt(userId));
//			              未来研究计划及当前研究基础
				JcqnDoc04 jcqn04 = jcqndoc01servive.getByUserId04(Integer.parseInt(userId));
//			             工作单位发展需求与推荐人选的相关性及工作单位提供的支持保障措施
				JcqnDoc05 jcqn05 = jcqndoc01servive.getByUserId05(Integer.parseInt(userId));
//				String path = request.getSession().getServletContext().getRealPath("/")+"fileUpload/";
				String fileName="jcqn.pdf";
				File file = new File(path);
	        	if(!file.exists()){
	        		file.mkdirs();
	        	}
	        	File file1 = new File(path,fileName);
	        	file1.createNewFile();
				new BasePDFWrite(file1,response).generateJcqnPDF(jcqn,userPeixuns,work,uesrZuzhis,jcqnDocProjects,jcqnDocPrizes,jcqnDocThesis,
						jcqnDocPatents,jcqnDocReports,jcqnDocTreatises,jcqn03,jcqn04,jcqn05);
				Attachfile f = new Attachfile();
				f.setNewfilename(fileName);
				f.setFile_path(path);
				f.setOldfilename(fileName);
				result.put("filename", fileName);
				result.put("path", path);
				System.err.println(result.toJSONString());
				 FileUtil.downloadPdfFile(response, f);
			}else if(applytype.equals("科技领军")){
//				基本信息
				 KjljDoc01 kjlj = kjljDocService.getByUserId01(Integer.parseInt(userId));
//			               推荐人选自我评价
				 KjljDoc03 kjlj03 = kjljDocService.getByUserId03(Integer.parseInt(userId));
//			              未来研究计划及当前研究基础
				 KjljDoc04 kjlj04 = kjljDocService.getByUserId04(Integer.parseInt(userId));
//			             工作单位发展需求与推荐人选的相关性及工作单位提供的支持保障措施
				 KjljDoc05 kjlj05 = kjljDocService.getByUserId05(Integer.parseInt(userId));
//	            String path = request.getSession().getServletContext().getRealPath("/")+"fileUpload/";
				String fileName="kjlj.pdf";
				File file = new File(path);
//		        File file = new File("C:\\Users\\bm\\Desktop\\kjlj.pdf");
	        	if(!file.exists()){
	        		file.mkdirs();
	        	}
	        	File file1 = new File(path,fileName);
	        	file1.createNewFile();
				new BasePDFWrite(file1,response).generateKjljPDF(kjlj,userPeixuns,work,uesrZuzhis,jcqnDocProjects,jcqnDocPrizes,jcqnDocThesis,
						jcqnDocPatents,jcqnDocReports,jcqnDocTreatises,kjlj03,kjlj04,kjlj05);
				Attachfile f = new Attachfile();
				f.setNewfilename(fileName);
				f.setFile_path(path);
				f.setOldfilename(fileName);
				result.put("filename", fileName);
				result.put("path", path);
				System.err.println(result.toJSONString());
				 FileUtil.downloadPdfFile(response, f);
			}else if(applytype.equals("创新团队")){
//				基本信息
				Map<String, Object> doc01 = new HashMap<String, Object>();
				doc01 = cxtdDocService.queryCxtdDoc01(Integer.parseInt(userId));
//				基本信息
				CxtdBaseInfo baseInfo = (CxtdBaseInfo) doc01.get("baseinfo");
//				领导人信息
				CxtdLeaderInfo leaderInfo = (CxtdLeaderInfo) doc01.get("leaderinfo");
//			            团队成员人数 
				CxtdMemberNum memNum = (CxtdMemberNum) doc01.get("memnum");
//				成员信息
				List<CxtdMemberInfo> mList = (List<CxtdMemberInfo>) doc01.get("mlist");
//				推荐人选自我评价
				 CxtdDoc03 cxtdDoc03 = cxtdDocService.getDao03(Integer.parseInt(userId));
//			              未来研究计划及当前研究基础
				 CxtdDoc04 cxtdDoc04 = cxtdDocService.getDoc4(Integer.parseInt(userId));
//			             工作单位发展需求与推荐人选的相关性及工作单位提供的支持保障措施
				 CxtdDoc05 cxtdDoc05 = cxtdDocService.getDoc05(Integer.parseInt(userId));
//	            String path = request.getSession().getServletContext().getRealPath("/")+"fileUpload/";
				String fileName="cxtd.pdf";
				File file = new File(path);
//		        File file = new File("C:\\Users\\bm\\Desktop\\cxtd.pdf");

	        	if(!file.exists()){
	        		file.mkdirs();
	        	}
	        	File file1 = new File(path,fileName);
	        	file1.createNewFile();
				new BasePDFWrite(file1,response).generateCxtdPDF(baseInfo,leaderInfo,memNum,mList,userPeixuns,work,uesrZuzhis,jcqnDocProjects,jcqnDocPrizes,jcqnDocThesis,
						jcqnDocPatents,jcqnDocReports,jcqnDocTreatises,cxtdDoc03,cxtdDoc04,cxtdDoc05);
				Attachfile f = new Attachfile();
				f.setNewfilename(fileName);
				f.setFile_path(path);
				f.setOldfilename(fileName);
				result.put("filename", fileName);
				result.put("path", path);
				System.err.println(result.toJSONString());
				 FileUtil.downloadPdfFile(response, f);
			}
            
		}

	// 通过id删除职称单条信息
	@RequestMapping(value = "zhichengApplyDelete", method = RequestMethod.POST)
	@ResponseBody
	public String zhichengApplyDelete(HttpServletRequest request, Model model) {
		JsonObject jsonResponse = new JsonObject();
		String Id = request.getParameter("id");
		int result = 0;// 0:fail;1:success
		String msg = "Failed to delete this user_work!";
		if (Id != null) {

			result = zhichengapplyservice.delete(Id) ? 1 : 0;
			msg = "You have successfully DELETED this zhicheng.";
		} else {
			return "404";
		}

		jsonResponse.addProperty("result", result);
		jsonResponse.addProperty("msg", msg);
		return jsonResponse.toString();

	}

	@RequestMapping(value = "zhichengApplyGetById", method = RequestMethod.GET)
	@ResponseBody
	public String zhichengApplyGetById(HttpServletRequest request, Model model) {

		String authority = "";

		SecurityContextImpl securityContextImpl = (SecurityContextImpl) request.getSession()
				.getAttribute("SPRING_SECURITY_CONTEXT");
		@SuppressWarnings("unchecked")
		List<GrantedAuthority> authorities = (List<GrantedAuthority>) securityContextImpl.getAuthentication()
				.getAuthorities();
		for (GrantedAuthority grantedAuthority : authorities) {
			authority = authority + grantedAuthority.getAuthority() + "|";
		}

		JSONObject jo3 = new JSONObject();
		jo3.put("authority", authority);

		JSONArray jsonArray = new JSONArray();
		String id = request.getParameter("id");
		if ((id != null) && (id.length() >= 1)) {
			ZhichengApply zhichengapply = zhichengapplyservice.getById(id);
			jsonArray.add(zhichengapply);
		} else {
			jsonArray.add(null);
		}
		jsonArray.add(jo3);
		return jsonArray.toString();
	}

	@RequestMapping(value = "expertzhichengApplylistInit", method = RequestMethod.GET)
	@ResponseBody
	public Object initApplyGroup(HttpServletRequest request) {
		HttpSession session = request.getSession();
		User user = (User) session.getAttribute("loginuser");
		ExpertUser expertUser = zhichengapplyservice.getByUserId(user.getId());
		// String group_id = request.getParameter("groupId");
		String role_type = request.getParameter("role_type");
		List<ApplyGroup> list = groupService.getApplyGroupById(Integer.valueOf(expertUser.getGroup_id()),
				Integer.valueOf(role_type));
		return list;
	}

	// 获取信息
	@RequestMapping(value = "/ExpertUserInit", method = RequestMethod.GET)
	@ResponseBody
	public ExpertUser jcqnDoc04Init(HttpServletRequest request) {
		JSONArray jsonArray = new JSONArray();
		String userId = request.getParameter("userId");
		System.err.println("-----------" + userId);
		ExpertUser expertUser = zhichengapplyservice.getByUserId(Integer.parseInt(userId));
		return expertUser;
	}

	/**
	 * 获取专家打分情况列表
	 * 
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "expertScoreList", method = RequestMethod.GET)
	public Object initExpertScore(HttpServletRequest request) {
		String apply_id = request.getParameter("applyid");

		// String role_type = request.getParameter("role_type");
		List<ExpertScore> groups = zhichengapplyservice.gExpertScore(Integer.valueOf(apply_id));
		return groups;
	}

	@RequestMapping(value = "expertScoreDetail", method = RequestMethod.GET)
	public String expertScoreDetail(HttpServletRequest request, Model model) {
		String applyid = request.getParameter("applyid");
		model.addAttribute("applyid", applyid);
		return "zhicheng/ExpertScore";
	}

	/**
	 * 获取专家投票情况列表
	 * 
	 * @param request
	 * @return
	 */
	@ResponseBody
	@RequestMapping(value = "expertVoteList", method = RequestMethod.GET)
	public Object initExpertVote(HttpServletRequest request) {
		String apply_id = request.getParameter("applyid");

		// String role_type = request.getParameter("role_type");
		List<ExpertVote> groups = zhichengapplyservice.gExpertVote(Integer.valueOf(apply_id));
		for (int i = 0; i < groups.size(); i++) {
			if (groups.get(i).getExpert_vote().equals("1")) {
				groups.get(i).setExpert_vote("通过");
			} else if (groups.get(i).getExpert_vote().equals("2")) {
				groups.get(i).setExpert_vote("不通过");
			} else if (groups.get(i).getExpert_vote().equals("3")) {
				groups.get(i).setExpert_vote("弃权");
			}
		}
		return groups;
	}

	@RequestMapping(value = "expertVoteDetail", method = RequestMethod.GET)
	public String expertVoteDetail(HttpServletRequest request, Model model) {
		String applyid = request.getParameter("applyid");
		model.addAttribute("applyid", applyid);
		return "zhicheng/ExpertVote";
	}
}
