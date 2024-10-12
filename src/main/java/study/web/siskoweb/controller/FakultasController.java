package study.web.siskoweb.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import study.web.siskoweb.model.request.FakultasReq;
import study.web.siskoweb.model.response.FakultasRes;
import study.web.siskoweb.model.service.FakultasService;

import java.util.Optional;


@Controller
@RequiredArgsConstructor
@RequestMapping("/fakultas")
public class FakultasController {

    private final FakultasService fakultasService;

    @GetMapping
    public ModelAndView index() {
        ModelAndView mav = new ModelAndView("pages/fakultas/index");
        mav.addObject("data", fakultasService.get());
        return mav;
    }

    @GetMapping("/add")
    public ModelAndView add() {
        ModelAndView mav = new ModelAndView("pages/fakultas/add");
        mav.addObject("data", new FakultasReq());
        return mav;
    }

    @GetMapping("/save")
    public ModelAndView save(@ModelAttribute FakultasReq fakultasReq) {
        ModelAndView mav = new ModelAndView("pages/fakultas/edit");
        this.fakultasService.save(fakultasReq);
        return new ModelAndView("redirect:/fakultas");
    }

    @GetMapping("/edit/{id}")
    public ModelAndView edit(@PathVariable String id) {
        ModelAndView mav = new ModelAndView("pages/fakultas/edit");

        Optional<FakultasRes> result = this.fakultasService.getByid(id);
        if (result.isPresent()) {
            mav.addObject("data", result.get());
            return mav;
        }
        return mav;
    }
}
