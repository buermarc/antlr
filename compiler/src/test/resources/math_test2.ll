declare i32 @printf(i8*, ...)
@.str_1 = private unnamed_addr constant [4 x i8] c"%d\0A\00"
@.str_2 = private unnamed_addr constant [4 x i8] c"%d\0A\00"

define void @main() {
%1 = udiv i32 1, 2
%2 = add i32 %1, 3
%3 = mul i32 4, 9
%4 = sub i32 %2, %3
%5 = sub i32 %4, 2
%6 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @.str_1, i64 0, i64 0),i32 %5)
%7 = udiv i32 1, 2
%8 = add i32 %7, 3
%9 = mul i32 4, 9
%10 = sub i32 %8, %9
%11 = sub i32 %10, 2
%12 = call i32 (i8*, ...) @printf(i8* getelementptr inbounds ([4 x i8], [4 x i8]* @.str_2, i64 0, i64 0),i32 %11)
ret void
}
