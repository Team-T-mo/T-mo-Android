package com.example.tmo.ui.main.util

import java.util.regex.Pattern

fun String.extractBiologicalClassification(): String {
    val pattern = Pattern.compile("\\|이름=(.*?)\\|학명=(.*?)\n", Pattern.DOTALL)
    val matcher = pattern.matcher(this)

    if (matcher.find()) {
        // 이름부터 학명까지 추출
        val nameToScientificName = matcher.group(0).trim()

        // 색, 그림, 그림_설명을 제거
        val filteredData = nameToScientificName
            .replace("\\|색=[^|]+".toRegex(), "")
            .replace("\\|그림=[^|]+".toRegex(), "")
            .replace("\\|그림_설명=[^|]+".toRegex(), "")

        // 데이터 분리
        val keyValuePairs = filteredData.split("\n").map { it.trim() }
        val formattedData = StringBuilder()

        for (keyValue in keyValuePairs) {
            val parts = keyValue.split("=")
            if (parts.size == 2) {
                val key = parts[0].trim().replace("|", "")
                val value = parts[1].trim()
                val processedValue = processValue(value) // "[[x|y]]" 데이터 처리
                formattedData.append("$key : $processedValue\n")
            }
        }
        return formattedData.toString()
    }
    return ""
}

private fun processValue(value: String): String {
    // "[[x|y]]" 형식의 데이터를 처리하여 "y" 추출
    val pattern = Pattern.compile("\\[\\[.*?\\|(.*?)\\]\\]")
    val matcher = pattern.matcher(value)

    if (matcher.find()) {
        return matcher.group(1).trim() // "y" 추출
    }

    // "[[x]]" 형식의 데이터를 처리하여 "x" 추출
    val pattern2 = Pattern.compile("\\[\\[(.*?)\\]\\]")
    val matcher2 = pattern2.matcher(value)

    if (matcher2.find()) {
        return matcher2.group(1).trim() // "x" 추출
    }
    return value // 어떤 패턴과도 매칭되지 않을 경우 그대로 반환
}

