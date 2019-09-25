package com.sl.automobile.controller;

import com.sl.automobile.pojo.Finance;
import com.sl.automobile.service.FinanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class FinanceController {
    @Autowired
    private FinanceService financeService;
    @RequestMapping("/loadFinanceAll")
    public String loadFinanceAll(Model model){
        List<Finance> financeList = financeService.loadFinanceAll();
        System.out.println(financeList);
        model.addAttribute("financeList", financeList);
        return "charts-4";
    }
    @ResponseBody
    @RequestMapping("/ec")
    public List<Integer> loadFinanceList(){
        List<Finance> finances = financeService.loadFinanceAll();
        List<Integer> accs = new ArrayList<>();
        for (Finance finance:finances){
            accs.add(finance.getOneQuarter());
            accs.add(finance.getTwoQuarter());
            accs.add(finance.getThreeQuarter());
            accs.add(finance.getFourQuarter());
        }
        return accs;
    }
}
