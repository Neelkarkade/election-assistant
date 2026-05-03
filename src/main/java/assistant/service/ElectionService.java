package assistant.service;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ElectionService {

    public List<String> getAnswer(String question) {

        question = question.toLowerCase().trim();

        if (question.startsWith("vote")) {
            return List.of(
                    "Register voter ID",
                    "Check polling booth",
                    "Go and vote");
        } else if (question.contains("timeline")) {
            return getTimeline();
        } else if (question.contains("eligibility")) {
            return getEligibility();
        } else if (question.contains("age")) {
            return List.of("Age must be 18+ to vote");
        } else if (question.contains("hi") || question.contains("hello")) {
            return List.of(
                    "Hello 👋",
                    "You can ask:",
                    "• Voting process",
                    "• Timeline",
                    "• Eligibility");
        } else {
            return List.of("Ask about voting, timeline or eligibility");
        }
    }

    public List<String> getTimeline() {
        return List.of(
                "Election Announcement",
                "Campaign Period",
                "Voting Day",
                "Result Declaration");
    }

    public List<String> getEligibility() {
        return List.of(
                "Age must be 18+",
                "Must be citizen",
                "Valid voter ID required");
    }
}