/*
package test;

public class VideoDownload {
    public static void main(String[] args) {

    }
    public function videoDownload()
    {

        String baseUrl = "https://media.scaler.com/production/protected-recordings/764628/777634/__segment:0111110211100101010012/stream_0/";
        String key = "?Key-Pair-Id=K4IMAQNEJMDV1&Policy=ewogICAgICAgICJTdGF0ZW1lbnQiOiBbCiAgICAgICAgICB7CiAgICAgICAgICAgICJSZXNvdXJjZSI6ICJodHRwczovL21lZGlhLnNjYWxlci5jb20vcHJvZHVjdGlvbi9wcm90ZWN0ZWQtcmVjb3JkaW5ncy83NjQ2MjgvNzc3NjM0L19fc2VnbWVudDowMTExMTEwMjExMTAwMTAxMDEwMDEyLyoiLAogICAgICAgICAgICAiQ29uZGl0aW9uIjogewogICAgICAgICAgICAgICAiSXBBZGRyZXNzIjogewogICAgICAgICAgICAgICAgICAiQVdTOlNvdXJjZUlwIjogIjAuMC4wLjAvMCIKICAgICAgICAgICAgICAgIH0sCiAgICAgICAgICAgICAgICAiRGF0ZUxlc3NUaGFuIjogewogICAgICAgICAgICAgICAgICAiQVdTOkVwb2NoVGltZSI6IDE3MDk4MTU5MjgKICAgICAgICAgICAgICAgIH0sCiAgICAgICAgICAgICAgICJEYXRlR3JlYXRlclRoYW4iOiB7CiAgICAgICAgICAgICAgICAgICJBV1M6RXBvY2hUaW1lIjogMTcwOTgwMTUyOAogICAgICAgICAgICAgICAgfQogICAgICAgICAgICB9CiAgICAgICAgICB9CiAgICAgICAgXQogICAgICB9CiAgICA_&Signature=Aq09r0YAzTBqr4gCBaB0Y1UQZ8GKtErUTNrsDW-SnQbdpDdUiLi4zIUzgB7frt-fKH8Zf2tOQDu08B04lFhN13rEjzIW~Cmfr9kZRJerVJbWWuLZHLnLyLIu6OU6d8OUbzAZRHBuaKvuiJC9hAprwiTF51lUK4OUmQw4OusLEkipNyDAuWQA4V75okjtpDplJfXmsW5COmEqiymOv3PKali~5lixHR9TN9~mZSiigazamuGz1rWxfv4K7WEMKXI3AEk94X0ZXJIrgKixx2R01bOU5VM3rwfmfg5Y6BHp6ma-EpSMh7CiRoz6nw7bE1ntqVrk~Tf8lYsAR3f2ulSTnQ__";

        String filePrefix = "data";
        // Set the starting and ending numbers
        int start = 1;
        int end = 100;

        // Loop through the sequence of numbers
        String [] segmentFiles = {};
        for (int i = start; i <= end; i++) {
            fileName = sprintf("%s%06d.ts", $filePrefix, $i);
            $segmentFiles[] = $fileName;
            $tempurl = $baseUrl.$fileName.$key;
            // Download the segment
            $response = Http::get($tempurl);
            file_put_contents(public_path($fileName), $response->body());
        }
        // return response()->download($fileName)->deleteFileAfterSend();
        return response()->json(['success' => 'download Successfully'], 200);
    }
}
*/
