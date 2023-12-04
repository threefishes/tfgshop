package cn.enilu.flash.api.controller.message;

import cn.enilu.flash.bean.constant.factory.PageFactory;
import cn.enilu.flash.bean.core.BussinessLog;
import cn.enilu.flash.bean.entity.message.MessageSender;
import cn.enilu.flash.bean.enumeration.Permission;
import cn.enilu.flash.bean.vo.front.Rets;
import cn.enilu.flash.bean.vo.query.SearchFilter;
import cn.enilu.flash.service.message.MessagesenderService;
import cn.enilu.flash.utils.factory.Page;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/message/sender")
public class MessagesenderController {
    @Autowired
    private MessagesenderService messagesenderService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    @RequiresPermissions(value = {Permission.MSG_SENDER})
    public Object list() {
        Page<MessageSender> page = new PageFactory<MessageSender>().defaultPage();
        page = messagesenderService.queryPage(page);
        page.setRecords(page.getRecords());
        return Rets.success(page);
    }

    @RequestMapping(value = "/queryAll", method = RequestMethod.GET)
    @RequiresPermissions(value = {Permission.MSG_SENDER})
    public Object queryAll() {
        return Rets.success(messagesenderService.queryAll());
    }

    @RequestMapping(method = RequestMethod.POST)
    @BussinessLog(value = "编辑消息发送者", key = "name")
    @RequiresPermissions(value = {Permission.MSG_SENDER_EDIT})
    public Object save(@ModelAttribute @Valid MessageSender messageSender) {
        if(messageSender.getId()!=null){
            MessageSender old = messagesenderService.get(messageSender.getId());
            old.setName(messageSender.getName());
            old.setClassName(messageSender.getClassName());
            messagesenderService.update(old);
        }else {

            MessageSender old = messagesenderService.get(SearchFilter.build("className",messageSender.getClassName()));
            if(old!=null){
                return Rets.failure("改短信发送器已存在，请勿重复添加");
            }
            messagesenderService.insert(messageSender);
        }
        return Rets.success();
    }

    @RequestMapping(method = RequestMethod.DELETE)
    @BussinessLog(value = "删除消息发送者", key = "id")
    @RequiresPermissions(value = {Permission.MSG_SENDER_DEL})
    public Object remove(Long id) {

        try {
            messagesenderService.deleteById(id);
            return Rets.success();
        } catch (Exception e) {
            return Rets.failure(e.getMessage());
        }

    }
}
