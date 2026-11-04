<!--
Tác giả: Vũ Quốc Hải + x6 Gehihi
Mở xem Markdown Preview trên VS Code: Ctrl+Shift+V (Windows/Linux) hoặc Cmd+Shift+V (macOS).
-->

# Prompt cho AI agent: Tổng hợp đề CSD201

Hãy làm việc trên thư mục dự án chứa đề thi và tài liệu môn Cấu trúc dữ liệu và giải thuật (CSD201, Đại học FPT). Mục tiêu là giải đề, kiểm chứng lời giải và tạo tài liệu tra cứu hữu ích. Trước khi bắt đầu, hãy kiểm kê các tệp/thư mục hiện có, xác định định dạng đề và ngôn ngữ/cấu trúc source code của dự án. Không tự bịa nội dung đề, đáp án, năm thi hoặc kết quả chạy.

## Quy trình

1. **Kiểm kê và phân loại:** tìm đề, đáp án/given, mã nguồn và tài liệu liên quan; nhóm theo năm, kỳ thi và mã đề nếu có. Ghi rõ thông tin nào không xác định được.
2. **Đọc hướng dẫn thi trước khi giải:** với từng đề, đọc phần hướng dẫn/quy định ở đầu PDF trước khi làm các câu hỏi. Ghi nhận và tuân thủ đúng các yêu cầu áp dụng cho đề đó, chẳng hạn ngôn ngữ, cấu trúc/nội dung cần nộp, giới hạn thư viện hoặc thao tác được phép, quy tắc đặt tên, định dạng input/output và yêu cầu trình bày. Ưu tiên hướng dẫn cụ thể của PDF đó hơn quy ước chung trong README này; không tự suy diễn thêm quy định. Nếu PDF không đọc rõ hoặc có yêu cầu mâu thuẫn, ghi rõ điểm chưa xác định và không tự đoán.
3. **Chép lại đề:** với mỗi câu, tạo bản văn bản có thể tìm bằng Ctrl+F. Giữ nguyên thuật ngữ, dữ liệu, ràng buộc, định dạng vào/ra và ví dụ. Đặt nguyên văn câu hỏi trong khối trích dẫn hoặc khối code để phân biệt với phần diễn giải. Nếu nguồn là ảnh/PDF khó đọc, đánh dấu `[không đọc rõ]`, không đoán.
4. **Giải đề:** giải từng ý theo đúng hướng dẫn thi của đề, nêu cách tiếp cận, cấu trúc dữ liệu/thuật toán, độ phức tạp thời gian và bộ nhớ, các trường hợp biên. Với câu lập trình, cung cấp mã hoàn chỉnh đúng ngôn ngữ, cấu trúc, giới hạn và quy ước nộp bài nêu trong PDF; giải thích cách biên dịch/chạy khi cần. Không viết comment trong code.
5. **Kiểm chứng:** đối chiếu lời giải với đề và given; chạy chương trình/test nếu môi trường cho phép. Ghi rõ lệnh chạy, kết quả thực tế, test tự tạo (bao gồm trường hợp biên) và giới hạn kiểm chứng. Không tuyên bố đã chạy nếu chưa chạy. Nếu given có thể sai hoặc lời giải chưa chắc chắn, nêu rõ điểm bất nhất và lý do.
6. **Tìm đề tương tự:** so sánh giữa các năm/kỳ/mã đề, đánh giá theo yêu cầu cốt lõi, thuật toán, cấu trúc dữ liệu và dạng input/output. Nhóm các câu trùng hoặc gần trùng; chỉ ra năm/câu, phần giống nhau và khác nhau (ví dụ dataset, tên biến, ràng buộc hay thay đổi logic nhỏ). Gán mức `Trùng`, `Rất giống`, `Có cùng dạng` hoặc `Khác`; giải thích ngắn gọn, không chỉ dựa vào từ ngữ giống nhau.
7. **Tạo và cập nhật README:** tổng hợp kết quả vào một file Markdown dễ đọc, có mục lục liên kết đến các tiêu đề. Giữ nguyên source đề, given và source code có sẵn; không ghi đè hay sửa chúng. Đặc biệt, không thêm, xóa hoặc sửa bất kỳ nội dung nào trong code của given nằm trong các file nén. Nếu một năm không có code base, chọn code base của năm khác có cấu trúc và yêu cầu tương ứng gần nhất làm mẫu; tạo bản riêng cho năm đó, giữ cấu trúc và format phù hợp nhưng không chép hoặc viết comment trong code, không sửa trực tiếp file nén gốc. Ghi rõ năm được mượn code base và nguồn mẫu; không tự nhận đó là given của năm đang làm. Lưu lời giải vào thư mục riêng có tên dễ hiểu, ưu tiên cấu trúc `solutions/<năm>/<mã-đề>/...` nếu phù hợp với dự án. Mỗi tiêu đề bài phải liên kết tương đối trực tiếp tới thư mục chứa lời giải; nếu Markdown không mở thư mục ổn định trên hệ điều hành hiện tại, liên kết tới tệp source chính và ghi đường dẫn thư mục rõ ràng. Dùng liên kết tương đối để tài liệu vẫn hoạt động khi di chuyển dự án.

## Cấu trúc README đầu ra

Đặt comment HTML ở đầu README kết quả, ví dụ:

```markdown
<!--
Tác giả: [Tên tác giả]
VS Code Markdown Preview: Ctrl+Shift+V (Windows/Linux), Cmd+Shift+V (macOS)
-->
```

Sau comment, sắp xếp nội dung theo các phần sau:

- **Mục lục** với liên kết nội bộ.
- **Hướng dẫn sử dụng:** cách xem README preview và cách chạy lời giải.
- **Tổng quan đề:** danh sách năm/kỳ/mã đề, nguồn tệp và tình trạng xử lý.
- **Lời giải theo từng đề:** mỗi câu gồm tiêu đề có liên kết tới source, năm/mã đề, nguyên văn đề, diễn giải khi cần, lời giải, mã nguồn/đường dẫn, cách chạy và kết quả kiểm chứng.
- **Hướng dẫn thi của từng đề:** tóm tắt các quy định ở đầu PDF và chỉ ra cách lời giải tuân thủ chúng; không thay thế hay diễn giải sai yêu cầu gốc.
- **Code base:** nếu đề/năm không có code base, ghi rõ code base tham khảo từ năm nào và đường dẫn nguồn; bản dùng cho năm đó giữ cấu trúc/format phù hợp nhưng không có comment trong code, đồng thời không chỉnh sửa given trong file nén.
- **Bảng câu tương tự/trùng:** nhóm theo chủ đề hoặc thuật toán, nêu các câu liên quan, mức độ và khác biệt cụ thể.
- **Hữu ích cho kỳ thi:** kiến thức ôn tập, lỗi thường gặp, chiến lược phân tích đề và các dạng bài có khả năng luyện thêm. Phân biệt nội dung suy ra từ bộ đề với gợi ý ôn tập chung; không khẳng định dự đoán là đề thi thật.
- **Tham khảo nhanh:** thuật toán/hàm thường dùng và hướng dẫn tái sử dụng code.

## Mục tham khảo nhanh cần có

Liệt kê ví dụ có giải thích ngắn, điều kiện sử dụng, độ phức tạp nếu phù hợp và mã minh họa đúng với ngôn ngữ dự án:

- kiểm tra số nguyên tố, số chẵn/lẻ; min/max; gcd/lcm;
- tìm kiếm tuyến tính và nhị phân (nêu rõ điều kiện mảng đã sắp xếp);
- sắp xếp; đếm tần suất; đảo chuỗi/mảng; kiểm tra palindrome;
- thao tác mảng, chuỗi, danh sách liên kết, stack, queue, cây và đồ thị nếu nằm trong phạm vi môn học;
- các mẫu thuật toán phù hợp với nội dung thực tế của bộ đề.

Hướng dẫn tái sử dụng theo đúng dự án: nên lưu hàm dùng chung ở tệp/module nào, cách import/include/call từ bài khác, cách biên dịch/link nếu cần và lưu ý tránh xung đột tên hoặc nhiều hàm `main`. Nếu môi trường thi yêu cầu nộp một tệp độc lập, chỉ cách chép phần cần thiết vào bài thi. Không giả định một ngôn ngữ cụ thể trước khi kiểm tra source; nếu đưa ví dụ ở ngôn ngữ khác, ghi rõ.

## Yêu cầu chất lượng

- Viết bằng tiếng Việt, giữ nguyên tên thuật toán và thuật ngữ cần thiết.
- Dùng tiêu đề rõ ràng, bảng cho dữ liệu so sánh phù hợp, code fence có nhãn ngôn ngữ và liên kết tương đối hợp lệ.
- Mỗi câu phải truy ngược được tới tệp nguồn đề; ghi đường dẫn tương đối và trang/vị trí nếu xác định được.
- Không bỏ sót câu; theo dõi tiến độ bằng checklist hoặc bảng trạng thái.
- Tách bạch **nguyên văn đề**, **lời giải**, **given/đáp án tham khảo** và **kết quả kiểm chứng**.
- Đọc và làm theo hướng dẫn thi ở đầu từng PDF; không dùng một quy ước chung để ghi đè yêu cầu riêng của đề.
- Không viết comment trong bất kỳ code nào được tạo. Không thêm, xóa hoặc chỉnh sửa code given nằm trong file nén. Khi tạo code base riêng cho năm thiếu source, dựa trên cấu trúc và format của mẫu phù hợp nhưng không chép comment vào code; không sửa file nén gốc.
- Trước khi kết thúc, rà soát liên kết, mục lục, tên/đường dẫn source, lỗi Markdown và tính nhất quán giữa lời giải với đề.
- Nếu không thể thực hiện một bước do thiếu công cụ hoặc tài liệu, ghi rõ phần chưa làm và lý do; tiếp tục hoàn thành các phần còn lại.
