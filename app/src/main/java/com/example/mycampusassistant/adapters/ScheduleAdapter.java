java
public class ScheduleAdapter extends RecyclerView.Adapter<ScheduleAdapter.ViewHolder> {
    private List<ClassSchedule> scheduleList;

    public ScheduleAdapter(List<ClassSchedule> scheduleList) {
        this.scheduleList = scheduleList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_schedule, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ClassSchedule schedule = scheduleList.get(position);
        holder.tvDay.setText(schedule.getDay());
        holder.tvTime.setText(schedule.getTime());
        holder.tvSubject.setText(schedule.getSubject());
    }

    @Override
    public int getItemCount() {
        return scheduleList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvDay, tvTime, tvSubject;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvDay = itemView.findViewById(R.id.tv_day);
            tvTime = itemView.findViewById(R.id.tv_time);
            tvSubject = itemView.findViewById(R.id.tv_subject);
        }
    }
}
