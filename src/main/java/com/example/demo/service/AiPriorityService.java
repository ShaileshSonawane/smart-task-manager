package com.example.demo.service;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class AiPriorityService {

    private static final List<String> HIGH_KEYWORDS = Arrays.asList(
        "urgent", "critical", "crash", "bug", "fix", "error", "down",
        "broken", "fail", "security", "login", "payment", "production", "asap"
    );

    private static final List<String> LOW_KEYWORDS = Arrays.asList(
        "docs", "documentation", "refactor", "cleanup", "style",
        "rename", "typo", "comment", "readme", "cosmetic", "design"
    );

    public String[] getPriorityAndReasoning(String title, String description) {
        String combined = (title + " " + description).toLowerCase();

        for (String keyword : HIGH_KEYWORDS) {
            if (combined.contains(keyword)) {
                return new String[]{
                    "high",
                    "Task contains high-priority keyword: '" + keyword + "'"
                };
            }
        }

        for (String keyword : LOW_KEYWORDS) {
            if (combined.contains(keyword)) {
                return new String[]{
                    "low",
                    "Task contains low-priority keyword: '" + keyword + "'"
                };
            }
        }

        return new String[]{
            "medium",
            "No specific priority indicators found, defaulting to medium"
        };
    }
}