package az.et.recap.lesson04.register_app.model;

public class CommonResponseDto<R> {

    private final R data;
    private final int status;

    public CommonResponseDto(R data, int status) {
        this.data = data;
        this.status = status;
    }

    @Override
    public String toString() {
        return "CommonResponseDto{" +
                "data=" + data +
                ", status=" + status +
                '}';
    }
}
