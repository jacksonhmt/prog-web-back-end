package br.edu.unievangelica.domain.coupon;

import br.edu.unievangelica.core.controller.ResponseAbstractController;
import br.edu.unievangelica.domain.product.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/coupon")
public class CouponController extends ResponseAbstractController {

    @Autowired
    CouponService couponService;

    @GetMapping(value = "/{coupon}")
    public ResponseEntity<?> findCouponByName(@PathVariable String coupon) {
        System.out.println("entrou no controller");
        return jsonResponse(couponService.findCouponByName(coupon));
    }

    @PostMapping
    public ResponseEntity<?> save(@Validated @RequestBody Coupon coupon){
        return jsonResponse(couponService.save(coupon));
    }
}
