export const capitalize = (str: string): string => {
  if (!str) return str;
  return str.charAt(0).toUpperCase() + str.slice(1);
};

export const formatDateTime = (date: Date): string => {
  // Example implementation
  return date.toLocaleString();
};

export {}