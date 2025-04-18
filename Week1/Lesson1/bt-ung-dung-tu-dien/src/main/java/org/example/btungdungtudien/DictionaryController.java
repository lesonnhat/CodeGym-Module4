package org.example.btungdungtudien;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.HashMap;
import java.util.Map;

@Controller
public class DictionaryController {

    private Map<String, String> dictionary;

    public DictionaryController() {
        dictionary = new HashMap<>();
        dictionary.put("hello", "xin chào");
        dictionary.put("goodbye", "tạm biệt");
        dictionary.put("thank you", "cảm ơn");
        // Thêm các từ khác tại đây
    }

    @GetMapping("/")
    public String showForm() {
        return "dictionary";
    }

    @PostMapping("/lookup")
    public String lookup(@RequestParam("word") String word, Model model) {
        String meaning = dictionary.get(word.toLowerCase());
        if (meaning != null) {
            model.addAttribute("meaning", meaning);
        } else {
            model.addAttribute("message", "Không tìm thấy từ này.");
        }
        return "result";
    }
}